package com.bit.servlet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailDaoOrcImpl implements EmailDao {
	// connection method
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try {
			// driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// connection create
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			// driver manager -> connection get
			conn = DriverManager.getConnection(dburl, "C##KHOH", "1234");
			
		} catch(ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	@Override
	public List<EmailVo> getList() {
		List<EmailVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT no, first_name, last_name, email, created_at " 
						+ "FROM emaillist ORDER BY created_at DESC";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				Date createdAt = rs.getDate(5);	//java.util.Date
				EmailVo vo = new EmailVo(no, firstName, lastName, email, createdAt);
				// 리스트에 추가
				list.add(vo);
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 정리
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int insert(EmailVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
