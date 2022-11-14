package net;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MsgMgr3 {	
	
	// 전역 선언한거 메소드로 다시 넣자. 메소드들이 동시에 실행될때 꼬이는 경우 발생.
	// 전역변수는 속성값에만 사용하자.
	
	private DBConnectionMgr pool;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	
	public MsgMgr3() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public void insertMsg(MessageBean3 bean) {
		
		try {
			con = pool.getConnection();
			sql = "INSERT INTO tblMessage VALUES(msg_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getFId());
			pstmt.setString(2, bean.getTId());
			pstmt.setString(3, bean.getMsg());
			int cnt = pstmt.executeUpdate();	// 실행된 row의 갯수를 반환
			
			if (cnt >= 1)
				System.out.println("메시지가 삽입되었습니다." +cnt);			// test
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			pool.freeConnection(con, pstmt);
		}
		
	}
	
	public Vector<MessageBean3> getMsgList(String id) {
		
		//MessageBean3 bean = new MessageBean3();	// 이렇게 하면 안된다. 덮어쓰기 안됨. dkfo while문 설명 참조
		Vector<MessageBean3> vlist = null;
		
		
		try {
			con = pool.getConnection();
			sql = "SELECT no, fid, tid, msg, mdate FROM tblMessage WHERE fid=? OR tid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			//System.out.println("getMsgList 진행"); // test
			vlist = new Vector<MessageBean3>();
			
			while (rs.next()) {
				MessageBean3 bean = new MessageBean3();	// 새로운 객체로 해야된다. 주소값이 벡터에 들어가기 때문
				bean.setNo(rs.getInt(1));
				bean.setFId(rs.getString(2));
				bean.setTId(rs.getString(3));
				bean.setMsg(rs.getString(4));
				bean.setMDate(rs.getString(5));
				vlist.addElement(bean);		// 주소값이 벡터에 들어간다. 따라서 while 동안 계속 새로운 객체를 생성해야한다.
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return vlist;
	}
	
	public MessageBean3 getMsg(int no) {
		
		MessageBean3 bean = new MessageBean3();	// try 밖에 선언해야한다.
		
		try {
			con = pool.getConnection();
			sql = "SELECT no, fid, tid, msg, mdate FROM tblMessage WHERE no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				bean.setNo(rs.getInt(1));
				bean.setFId(rs.getString(2));
				bean.setTId(rs.getString(3));
				bean.setMsg(rs.getString(4));
				bean.setMDate(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return bean;
	}
}
