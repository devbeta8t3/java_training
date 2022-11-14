package net.problem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TalkMgr {
	
	private DBConnectionMgr pool;
	
	public TalkMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	/**
	 *  Login - 성공이면 true 리턴 
	 */
	public boolean loginChk(String id, String pwd) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;	// 제어권
		
		try {
			con = pool.getConnection();
			sql = "select count(id) from tblRegister where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			//System.out.println("ResultSet 객체는 " +rs);	// test - 결과값 rs 출력(서버 터미널)
			if (rs.next() && rs.getInt(1)==1) {
				flag = true;
			}
			//System.out.println("현재 flag 상태는" +flag);	// test - flag 상태 출력(서버 터미널)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
		
	}
	
}
