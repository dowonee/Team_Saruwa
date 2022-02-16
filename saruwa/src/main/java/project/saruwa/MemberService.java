package project.saruwa;

 
import java.util.Scanner;

public class MemberService {
   
   Scanner sc = new Scanner(System.in);   
   MemberDao dao = new MemberDao();
   
   //회원가입
   public boolean register(Member m) {
	   String pwPattern = "^(?=.*[0-9])(?=.*[\\W])(?=.*[a-z]).{8,20}$";
	   
	   boolean memCk = true;
	   while(memCk) {
		   if(m.getMemId().length()<5||m.getMemId().length()>15) {
			   System.out.println("아이디는 5~15자 사이로 입력해주세요.");
			   System.out.print("아이디: ");
			   m.setMemId(sc.nextLine());
		   }
		   if(dao.crtId(m)) {
			   System.out.println("중복되는 아이디가 있습니다.");
			   System.out.print("아이디: ");
			   m.setMemId(sc.nextLine());
		   }
		   if(m.getMemPass().length()<8||m.getMemPass().length()>30) {
			   System.out.println("비밀번호는 최소 8자 이상 입력해주세요.");
			   System.out.print("비밀번호: ");
			   m.setMemPass(sc.nextLine());
		   }
		   if(m.getMemPass().contains(" ")) {
			   System.out.println("공백은 포함할 수 없습니다.");
			   System.out.print("비밀번호: ");
			   m.setMemPass(sc.nextLine());
		   } 
		   if(!m.getMemPass().matches(pwPattern)) {
			   System.out.println("비밀번호는 숫자+영문+특수문자를 조합해주세요.");
			   System.out.print("비밀번호: ");
			   m.setMemPass(sc.nextLine());
		   }
		   if(dao.crtEmail(m)) {
			   System.out.println("중복되는 이메일이 있습니다.");
			   System.out.print("이메일: ");
			   m.setMemEmail(sc.nextLine());
		   }
		   else {
			   memCk = false;
			   System.out.println("정보 입력 성공");
		   }
	   }

	    boolean certi = true;
	    boolean certiPhone = true;
		while(certi) {
		       System.out.println("# 본인 인증 중 #");
		       System.out.print("휴대폰번호: 010");
		       m.setPhoneNum(sc.nextLine());
		       while(certiPhone) {
				   if(dao.crtPhone(m)) {
					   System.out.println("중복되는 휴대폰번호가 있습니다.");
					   System.out.print("휴대폰번호: 010");
					   m.setCerPhone(sc.nextLine());
				   }
				   else {
					   certiPhone=false;
				   }
		       }
		       String cerNum = "";
		       for(int cnt=1;cnt<=5;cnt++) {
		    	   int num = (int)(Math.random()*10+48);
		    	   cerNum += (char)num;
		       }
		       System.out.println("발송된 인증번호: "+cerNum);
		       System.out.print("인증번호 입력: ");
		       if(sc.nextLine().equals(cerNum)) {
		    	   System.out.println("# 본인 인증 완료 #");
		    	   certi = false;
		       } 
		       else {
		    	   System.out.println("# 본인 인증 실패 #");
		       }
	       }
		
	       return dao.register(m);
	    }
   //로그인
     public boolean login(String id,String pass) {
        if(dao.login(id, pass)) {
           System.out.println("로그인 성공");
           return true;
        }else {
           System.out.println("아이디/비밀번호를 재확인해주세요.");
           return false;
        }
   }
}
