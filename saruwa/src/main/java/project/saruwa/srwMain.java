package project.saruwa;

import java.util.Scanner;


public class srwMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		srwController ctrl = new srwController();
		 MemberController ctrl2 = new MemberController();
		Scanner sc = new Scanner(System.in);
		String id ="";
		String pass = "";
		boolean x = true;

		while(x) {
			System.out.println("## SARUWA 상품페이지 ##");
			System.out.println("[1]베스트상품 [2]상품리스트");
			System.out.println("");
			int cho = Integer.parseInt(sc.nextLine());
			switch(cho) {
			case 1:
						System.out.println("# 베스트상품 #");
						ctrl.bestlist(new Model());
						System.out.println("[1]바로구매 [2]좋아요 [3]장바구니");
						int cho2 = Integer.parseInt(sc.nextLine());
						if(cho2==1) {
							 System.out.println("# SARUWA 로그인 #");
						      System.out.println("[1]로그인 [2]회원가입");
						      System.out.print("선택: ");
						      int num = Integer.parseInt(sc.nextLine());
						      switch(num) {
						      	case 1 :
						      	  System.out.print("아이디: ");
						      	  id = sc.nextLine();
						      	  System.out.print("패스워드: ");
						      	  pass = sc.nextLine();
							      ctrl2.login(id, pass, new Model());
							      System.out.println("수량: ");
							      int cnt = Integer.parseInt(sc.nextLine());
							      System.out.println("사이즈: ");
							      String size = sc.nextLine();
							      System.out.println("주소: ");
							      String address = sc.nextLine();
							
							      ctrl.memorder(new Model(),id,address,size,cnt);
							      
							      break;
						      	case 2 :
							      ctrl2.register(new Member(), new Model()); 
							      break;
						      }
		
						} else if(cho2==2) {
							System.out.println("# SARUWA 로그인 #");
						      System.out.println("[1]로그인 [2]회원가입");
						      System.out.print("선택: ");
						      int num = Integer.parseInt(sc.nextLine());
						      switch(num) {
						      	case 1 :
						      	  System.out.print("아이디: ");
						      	  id = sc.nextLine();
						      	  System.out.print("패스워드: ");
						      	  pass = sc.nextLine();
							      ctrl2.login(id, pass, new Model());
							      
							      
							      ctrl.like(new Model(), id);
							
							      break;
						    	case 2 :
								  ctrl2.register(new Member(), new Model()); 
								  break;
								} 
					
						break;
									
						} else if(cho2==3) {
							 System.out.println("# SARUWA 로그인 #");
						      System.out.println("[1]로그인 [2]회원가입");
						      System.out.print("선택: ");
						      int num = Integer.parseInt(sc.nextLine());
						      switch(num) {
						      	case 1 :
						      	  System.out.print("아이디: ");
						      	  id = sc.nextLine();
						      	  System.out.print("패스워드: ");
						      	  pass = sc.nextLine();
							      ctrl2.login(id, pass, new Model());
							      
							      System.out.print("사이즈: ");
							      String size = sc.nextLine();
							      System.out.print("수량: ");
							      int cnt = Integer.parseInt(sc.nextLine());
							      
							ctrl.basket(new Model(), id, size, cnt);
							
							      break;
						    	case 2 :
								  ctrl2.register(new Member(), new Model()); 
								  break;
						} 
			
				break;
		
		}
			case 2:
				System.out.println("# 상품리스트 #");
				ctrl.Profillist(new Model()); 
				ctrl.detlist(new Model());
							System.out.println("[1]바로구매 [2]좋아요 [3]장바구니");
							int cho3 = Integer.parseInt(sc.nextLine());
							if(cho3==1) {
								 System.out.println("# SARUWA 로그인 #");
							      System.out.println("[1]로그인 [2]회원가입");
							      System.out.print("선택: ");
							      int num = Integer.parseInt(sc.nextLine());
							      switch(num) {
							      	case 1 :
							      	  System.out.print("아이디: ");
							      	  id = sc.nextLine();
							      	  System.out.print("패스워드: ");
							      	  pass = sc.nextLine();
								      ctrl2.login(id, pass, new Model());
								      System.out.println("수량: ");
								      int cnt = Integer.parseInt(sc.nextLine());
								      System.out.println("사이즈: ");
								      String size = sc.nextLine();
								      System.out.println("주소: ");
								      String address = sc.nextLine();
								
								ctrl.memorder(new Model(),id,address,size,cnt);
								      break;
							      	case 2 :
								      ctrl2.register(new Member(), new Model()); 
								      break;
							      }

							} else if(cho3==2) {
								System.out.println("# SARUWA 로그인 #");
							      System.out.println("[1]로그인 [2]회원가입");
							      System.out.print("선택: ");
							      int num = Integer.parseInt(sc.nextLine());
							      switch(num) {
							      	case 1 :
							      	  System.out.print("아이디: ");
							      	  id = sc.nextLine();
							      	  System.out.print("패스워드: ");
							      	  pass = sc.nextLine();
								      ctrl2.login(id, pass, new Model());
								      
								      
								ctrl.like(new Model(), id);
								
								      break;
							    	case 2 :
									  ctrl2.register(new Member(), new Model()); 
									  break;
									} 
						
							break;
										
							} else if(cho3==3) {
								 System.out.println("# SARUWA 로그인 #");
							      System.out.println("[1]로그인 [2]회원가입");
							      System.out.print("선택: ");
							      int num = Integer.parseInt(sc.nextLine());
							      switch(num) {
							      	case 1 :
							      	  System.out.print("아이디: ");
							      	  id = sc.nextLine();
							      	  System.out.print("패스워드: ");
							      	  pass = sc.nextLine();
								      ctrl2.login(id, pass, new Model());
								      
								      System.out.print("사이즈: ");
								      String size = sc.nextLine();
								      System.out.print("수량: ");
								      int cnt = Integer.parseInt(sc.nextLine());
								      
								ctrl.basket(new Model(), id, size, cnt);
								
								      break;
							    	case 2 :
									  ctrl2.register(new Member(), new Model()); 
									  break;
							} 
				
					break;

			}
		}
		
		

		}

	}
}