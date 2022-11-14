package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberMgr {
	
	DBConnectionMgr pool;
	
	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	// 리스트
	public Vector<MemberBean> getMemberList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<MemberBean> vlist = new Vector<MemberBean>();
		
		try {
			con = pool.getConnection();	// pool에서 Connection 객체를 빌려옴
			sql = "SELECT * FROM tblMember";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	// query 실행
			
			while (rs.next()) {
				MemberBean bean = new MemberBean(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("team"), rs.getString("address"));
				vlist.addElement(bean);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// con 반납, pstmt, rs는 close
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	// 저장
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "INSERT INTO tblMember VALUES(mem_seq.nextval, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getTeam());
			int cnt = pstmt.executeUpdate();	// 적용된 레코드 개수 리턴
			
			if (cnt==1) flag = true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// con 반납, pstmt는 close
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	// 하나의 레코드
	public MemberBean getMember(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		
		try {
			con = pool.getConnection();
			sql = "SELECT id, name, phone, address, team FROM tblMember WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPhone(rs.getString(3));
				bean.setAddress(rs.getString(4));
				bean.setTeam(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	// 수정
	public boolean updateMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;

		try {
			con = pool.getConnection();
			sql = "UPDATE tblMember SET name=?, phone=?, address=?, team=? WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getTeam());
			pstmt.setInt(5, bean.getId());
			
			int cnt = pstmt.executeUpdate();
			if (cnt==1) flag = true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	// 삭제
	public boolean deleteMember(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "DELETE FROM tblMember WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			int cnt = pstmt.executeUpdate();
			if (cnt==1) flag = true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	/* 팀 리스트 가져오기 */
	public Vector<String> getTeamList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<String> vlist = new Vector<String>();
		
		try {
			con = pool.getConnection();
			sql = "SELECT DISTINCT team FROM tblMember";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vlist.addElement(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	/* 우편번호 검색 */
	public Vector<ZipcodeBean> getZipcodeList(String area3) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<ZipcodeBean> vlist = new Vector<ZipcodeBean>();
		
		try {
			con = pool.getConnection();
			sql = "SELECT Zipcode, area1, area2, area3 FROM tblZipcode WHERE area3 like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" +area3+ "%"); // like '%강남대로%'
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ZipcodeBean bean = new ZipcodeBean();
				bean.setZipcode(rs.getString(1));
				bean.setArea1(rs.getString(2));
				bean.setArea2(rs.getString(3));
				bean.setArea3(rs.getString(4).trim());	// db에 공백값이 많아서 trim() 추가
				
				vlist.addElement(bean);	// vlist에는 reference address가 저장된다.
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
}
