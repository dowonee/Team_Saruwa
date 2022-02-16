package project.saruwa.manage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.saruwa.Member;



public class Dao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	// 관리자 페이지 로그인
	public boolean login(String i, int p) {
		boolean result = false;
		try {
			String sql = "SELECT * from adMember where id = ? and pass = ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, i);
			pstm.setInt(2, p);
			rs = pstm.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e1) {
				throw new RuntimeException(e1.getMessage());
			}
		}
		return result;
	}

	// 회원정보 통계 - 최근회원가입자 정보
	public ArrayList<Member> thisWeekMemberInfo() {
		ArrayList<Member> mlist = new ArrayList<Member>();
		try {
			String sql = "SELECT * FROM (SELECT * FROM saruwa_mem ORDER BY mdate desc) WHERE rownum <= 3";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setMdate(rs.getString("mdate"));
				m.setMemId(rs.getString("memid"));
				m.setMemEmail(rs.getString("email"));
				m.setMrkAgree(rs.getInt("mkagr"));
				mlist.add(m);
			}
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return mlist;
	}
	// 회원수 통계
	public int[] total() {
		int[] list = new int[4];
		try {
			String sql = "select count(*) from saruwa_mem where to_char(mdate,'YYYY/MM/DD') = to_char(sysdate,'YYYY/MM/DD')";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				list[0] = rs.getInt(1);
			}
			sql = "select count(*) from saruwa_mem where mdate between trunc(sysdate,'iw') and"
					+ " trunc(sysdate,'iw') - (1/24/60/60)";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				list[1] = rs.getInt(1);
			}
			sql = "select count(*) from drop_saruwa_mem";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				list[2] = rs.getInt(1);
			}
			sql = "select count(*) from saruwa_mem";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				list[3] = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return list;
	}
	// 회원정보 나열/정렬
	public ArrayList<Member> memberInfo(String s){
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			if(s.equals("")) {
				String sql = "select * from saruwa_mem";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			}else {
				String sql = "select * from saruwa_mem order by mdate " + s;
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			}
			while(rs.next()) {
				Member m = new Member();
				m.setMemId(rs.getString("memid"));
				m.setMemEmail(rs.getString("email"));
				m.setPhoneNum(rs.getString("phone"));
				m.setMrkAgree(rs.getInt("mkagr"));
				m.setMdate(rs.getString("mdate"));
				list.add(m);
			}
		}catch(SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return list;
	}
}