package project.saruwa;


import java.util.Scanner;

public class MemberController {
	
	MemberService service = new MemberService();
	Scanner sc = new Scanner(System.in);	
	
    public String register(Member m, Model d) {
  	  System.out.println("# 회원가입 #");
      System.out.print("아이디:");
      m.setMemId(sc.nextLine());
      System.out.print("비밀번호:");
      m.setMemPass(sc.nextLine());
      System.out.print("이메일주소:");
      m.setMemEmail(sc.nextLine());
      System.out.print("마케팅 정보 동의(Y/N):");
      if(sc.nextLine().equals("Y")) {
   	   m.setMrkAgree(1);
      }else if(sc.nextLine().equals("N")){
   	   m.setMrkAgree(2);
      } // 화면구현시 처리될 내용(약관 동의)
    	d.addAttribute("회원가입결과", service.register(m));
         return "호출될 화면";
      }
    
    public String login(String id,String pass,Model d) {
      d.addAttribute("로그인결과", service.login(id, pass));
      return "화면호출";
   }
}
