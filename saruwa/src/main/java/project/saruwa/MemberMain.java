package project.saruwa;


import java.util.Scanner;

public class MemberMain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Scanner sc = new Scanner(System.in);
      MemberController ctrl = new MemberController();
      
      System.out.println("# SARUWA 로그인 #");
      System.out.println("[1]로그인 [2]회원가입");
      System.out.print("선택: ");
      int num = sc.nextInt();
      switch(num) {
      	case 1 :
      	  String id = "";
      	  String pass = "";
	      ctrl.login(id, pass, new Model());
	      break;
      	case 2 :
	      ctrl.register(new Member(), new Model()); 
	      break;
      }
      


   }

}