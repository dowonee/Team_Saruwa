package project.saruwa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




 

public class MemberDao {

   Connection conn = null; 
   PreparedStatement pstm = null; 
   ResultSet rs = null;  
   // 회원가입
   public boolean register(Member m) {
      boolean flag = false;
      try {
         String sql = "insert into saruwa_mem(memid,mpass,email,phone,mkagr)"
               + "values(?,?,?,?,?)";
         conn = DBConnection.getConnection();
         pstm = conn.prepareStatement(sql);
         pstm.setString(1, m.getMemId());
         pstm.setString(2, m.getMemPass());
         pstm.setString(3, m.getMemEmail());
         pstm.setString(4, m.getPhoneNum());
         pstm.setInt(5, m.getMrkAgree());
         if(pstm.executeUpdate() == 1) { flag = true;}
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
      return flag;
   }

   public boolean crtId(Member m){
	   boolean flag = false;
	   try {
		   String sql = "SELECT * FROM saruwa_mem where memid = ?";
		   conn = DBConnection.getConnection();
		   pstm = conn.prepareStatement(sql);
		   pstm.setString(1, m.getMemId());
		   rs = pstm.executeQuery();
		   flag = rs.next(); //true면 중복, false면 중복되는 정보 없음
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
	   return flag;
   }
   public boolean crtEmail(Member m){
	   boolean flag = false;
	   try {
		   String sql = "SELECT * FROM saruwa_mem where email = ?";
		   conn = DBConnection.getConnection();
		   pstm = conn.prepareStatement(sql);
		   pstm.setString(1, m.getMemEmail());
		   rs = pstm.executeQuery();
		   flag = rs.next(); //true면 중복, false면 중복되는 정보 없음
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
	   return flag;
   }
   public boolean crtPhone(Member m){
	   boolean flag = false;
	   try {
		   String sql = "SELECT * FROM saruwa_mem where phone = ?";
		   conn = DBConnection.getConnection();
		   pstm = conn.prepareStatement(sql);
		   pstm.setString(1, m.getPhoneNum());
		   rs = pstm.executeQuery();
		   flag = rs.next(); //true면 중복, false면 중복되는 정보 없음
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
	   return flag;
   }
   // 로그인   
   public boolean login(String id,String pass){
      boolean flag = false;
      try {
         String sql = "SELECT * FROM saruwa_mem where memid = ? and mpass = ?";
         conn = DBConnection.getConnection();
         pstm = conn.prepareStatement(sql);
         pstm.setString(1, id);
         pstm.setString(2, pass);
         rs = pstm.executeQuery();
         flag = rs.next(); //true면 로그인 성공, false 면 로그인 실패
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
      return flag;
   }
}
