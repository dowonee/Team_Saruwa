package project.saruwa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class srwDao {
	//상품필터링 
	public ArrayList<srwProduct> profilter(String pcode, String price, String price2, String pdate){
		ArrayList<srwProduct> list = new ArrayList<srwProduct>();
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null;
		try {
				//상의-낮은가격순
			if(pcode.equals("상의") && price.equals("v") && price2.equals("") && pdate.equals("")) {
				String sql = "SELECT pcode, pname, pbrand, color, price, pdate FROM SPRODUCT WHERE pcode LIKE '%TP%' ORDER BY price";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				//상의 높은가격순
			} else if (pcode.equals("상의") && price.equals("") && price2.equals("v") && pdate.equals("")) {
				String sql = "SELECT pcode, pname, pbrand, color, price, pdate FROM SPRODUCT WHERE pcode LIKE '%TP%' ORDER BY price DESC";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				//상의 신상품순
			} else if (pcode.equals("상의") && price.equals("") && price2.equals("") && pdate.equals("v")) {
				String sql = "SELECT pcode, pname, pbrand, color, price, pdate FROM SPRODUCT WHERE pcode LIKE '%TP%' ORDER BY pdate DESC";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				//아우터 낮은가격순
			} else if (pcode.equals("아우터") && price.equals("v") && price2.equals("") && pdate.equals("")) {
				String sql = "SELECT pcode, pname, pbrand, color, price, pdate FROM SPRODUCT WHERE pcode LIKE '%OT%' ORDER BY price";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				//아우터 높은가격순
			} else if (pcode.equals("아우터") && price.equals("") && price2.equals("v") && pdate.equals("")) {
				String sql = "SELECT pcode, pname, pbrand, color, price, pdate FROM SPRODUCT WHERE pcode LIKE '%OT%' ORDER BY price DESC";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				//아우터 신상품순
			} else if (pcode.equals("아우터") && price.equals("") && price2.equals("") && pdate.equals("v")) {
				String sql = "SELECT pcode, pname, pbrand, color, price, pdate FROM SPRODUCT WHERE pcode LIKE '%OT%' ORDER BY pdate DESC";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				//상의 추천순(판매량)
			} else if (pcode.equals("상의") && price.equals("") && price2.equals("") && pdate.equals("")) {
				String sql = "SELECT a.pname, pcode, pbrand,color,price,pdate,b.cnt FROM sproduct a,(SELECT cnt, pname FROM (SELECT sum(cnt) cnt, pname FROM sorder GROUP BY pname)) b WHERE a.pname = b.pname AND pcode LIKE '%TP%' ORDER BY cnt desc";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				//아우터 신상품순
			} else if (pcode.equals("아우터") && price.equals("") && price2.equals("") && pdate.equals("")) {
				String sql = "SELECT a.pname, pcode, pbrand,color,price,pdate,b.cnt FROM sproduct a,(SELECT cnt, pname FROM (SELECT sum(cnt) cnt, pname FROM sorder GROUP BY pname)) b WHERE a.pname = b.pname AND pcode LIKE '%OT%' ORDER BY cnt desc";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			} else {
				System.out.println("하나만 선택해주세요.");
			}
			
			while (rs.next()) {
				srwProduct sl = new srwProduct();
				sl.setPcode(rs.getString("pcode"));
				sl.setPname(rs.getString("pname"));
				sl.setPbrand(rs.getString("pbrand"));
				sl.setColor(rs.getString("color"));
				sl.setPrice(rs.getString("price"));
				sl.setPrice2(rs.getString("price"));
				sl.setPdate(rs.getString("pdate"));
				list.add(sl);
			}
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally{
			// DB 연결을 종료한다.
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
	
	
	//베스트상품 리스트
	public ArrayList<srwProduct> probest(){
		ArrayList<srwProduct> list = new ArrayList<srwProduct>();
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null;
		try {
			String sql = "SELECT a.pname, pcode, pbrand,color,price,pdate,b.cnt FROM sproduct a,(SELECT cnt, pname FROM (SELECT sum(cnt) cnt, pname FROM sorder GROUP BY pname)) b WHERE a.pname = b.pname ORDER BY cnt desc";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				srwProduct sl = new srwProduct();
				sl.setPcode(rs.getString("pcode"));
				sl.setPname(rs.getString("pname"));
				sl.setPbrand(rs.getString("pbrand"));
				sl.setColor(rs.getString("color"));
				sl.setPrice(rs.getString("price"));
				sl.setPdate(rs.getString("pdate"));
				sl.setTolcnt(rs.getInt("cnt"));
				list.add(sl);
			}
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally{
			// DB 연결을 종료한다.
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
	
	//상품상세보기
	public srwProduct prodetl(String pname){
		srwProduct list = new srwProduct();
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null;
		try {
			String sql = "SELECT p.pcode, pname, pbrand, color, price, pdate, psize FROM sproduct p, stock s WHERE p.pcode = s.PCODE AND pname LIKE ? AND ROWNUM <= 1";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + pname + "%");
			rs = pstm.executeQuery();
			if (rs.next()) {
				list.setPcode(rs.getString("pcode"));
				list.setPname(rs.getString("pname"));
				list.setPbrand(rs.getString("pbrand"));
				list.setColor(rs.getString("color"));
				list.setPrice(rs.getString("price"));
				list.setPdate(rs.getString("pdate"));
				list.setSize(rs.getString("psize"));
			}
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally{
			// DB 연결을 종료한다.
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
	
	//사이즈불러오기
	public ArrayList<srwProduct> psize(String pname){
		ArrayList<srwProduct> list = new ArrayList<srwProduct>();
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null;
		try {
			String sql = "SELECT s.psize FROM sproduct p, stock s WHERE p.pcode = s.PCODE AND pname LIKE ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + pname + "%");
			rs = pstm.executeQuery();
			while (rs.next()) {
				srwProduct sl = new srwProduct();
				sl.setSize(rs.getString("psize"));
				list.add(sl);
			}
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally{
			// DB 연결을 종료한다.
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
	
	//주문서
	Connection conn = null; 
	PreparedStatement pstm = null; 
	ResultSet rs = null; 
	public void sorder(String code,String id,String address,String size,int cnt,String pname,String color) {
		try {
			String sql = "insert into sorder(ordercode,memid,address,pname,color,psize,cnt,orderdate)"
					+ "values(?,?,?,?,?,?,?,sysdate)";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, code);
			pstm.setString(2, id);
			pstm.setString(3, address);
			pstm.setString(4, pname);
			pstm.setString(5, color);
			pstm.setString(6, size);
			pstm.setInt(7, cnt);
			rs = pstm.executeQuery();
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
		} finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e1) {
				throw new RuntimeException(e1.getMessage());
			}
		}
	}
	
	
	//장바구니
	public void sbasket(String id,String pname,String price,String color,String size,int cnt) {
		try {
			String sql = "insert into sbasket(memid,pname,price,color,psize,cnt)"
					+ "values(?,?,?,?,?,?)";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pname);
			pstm.setString(3, price);
			pstm.setString(4, color);
			pstm.setString(5, size);
			pstm.setInt(6, cnt);
			rs = pstm.executeQuery();
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
		} finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e1) {
				throw new RuntimeException(e1.getMessage());
			}
		}
	}
	
	//좋아요
	public void slike(String id,String pname) {
		try {
			String sql = "insert into sbasket(memid,pname)"
					+ "values(?,?)";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pname);
			rs = pstm.executeQuery();
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
		} finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e1) {
				throw new RuntimeException(e1.getMessage());
			}
		}
	}
	
	// 비슷한 상품
	public ArrayList<srwProduct> similar(String pname,String price, String pbrand, String color){
		ArrayList<srwProduct> list = new ArrayList<srwProduct>();
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null;
		try {
			String sql = "SELECT PNAME, COLOR, PRICE, PBRAND FROM SPRODUCT WHERE PBRAND = ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pbrand);
			rs = pstm.executeQuery();
			while (rs.next()) {
				srwProduct sl = new srwProduct();
				sl.setPname(rs.getString("pname"));
				sl.setColor(rs.getString("color"));
				sl.setPrice(rs.getString("price"));
				sl.setPbrand(rs.getString("pbrand"));
				list.add(sl);
			}
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally{
			// DB 연결을 종료한다.
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
