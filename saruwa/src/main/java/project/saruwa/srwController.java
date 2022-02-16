package project.saruwa;

import java.util.Scanner;


public class srwController {

	srwService service = new srwService();
	Scanner sc = new Scanner(System.in);
	String name = "";
	String color = "";
	String price = "";
	String pbrand = "";
	//상품리스트,필터
	public String Profillist(Model d) {
		System.out.println("# 상품필터 #");
		System.out.print("카테고리(아우터/상의/하의/원피스/악세사리):");
		String pcode = sc.nextLine();
		
	      System.out.println("검색할 필터조건에 체크(v)하세요");
	      System.out.println("필터를 설정하지않으면 추천순으로 보여집니다.");
	      	System.out.print("낮은가격순:");
	      	String price = sc.nextLine();
	      	System.out.print("높은가격순:");
	      	String price2 = sc.nextLine();
	      	System.out.print("신상품순:");
	    	String pdate = sc.nextLine();
	    	

		d.addAttribute("상품리스트 출력", service.Profilter(pcode,price,price2,pdate));
		return "호출될 화면";
	}
	

	//베스트상품리스트
	public String bestlist(Model d) {
		d.addAttribute("베스트상품 출력", service.Bestlist());
		return "호출될 화면";
	}
	
	//상품상세페이지
	public String detlist(Model d) {
		System.out.println("# 상세페이지 #");
		System.out.print("제품명을 입력하세요 :");
		String pname = sc.nextLine();
		srwProduct list = service.Detlist(pname);
		name = list.getPname();
		color = list.getColor();
		price = list.getPrice();
		pbrand = list.getPbrand();
		d.addAttribute("상세페이지 출력", list);
		simp(d);
		return "호출될 화면";
	}
	
	//주문서
	public String memorder(Model d,String id,String address,String size,int cnt) {
		System.out.println("# 상품주문서 #");
		d.addAttribute("주문 출력", service.orderlist(id,address,size,cnt,name,color));
		return "호출될 화면";
	}
	
	//장바구니
	public String basket(Model d,String id,String size,int cnt) {
		System.out.println("# 장바구니 #");
		d.addAttribute("장바구니 출력", service.basketlist(id,name,price,color,size,cnt));
		return "호출될 화면";
	}
	
	//좋아요
	public String like(Model d,String id) {
		System.out.println("# 좋아요 #");
		d.addAttribute("좋아요 출력", service.likelist(id,name));
		return "호출될 화면";
	}
	
	//비슷한 상품
	public String simp(Model d) {
		System.out.println("# 비슷한 상품 #");
		d.addAttribute("비슷한상품리스트 출력", service.similarlist(name, price, pbrand, color));
		return "호출될 화면";
	}
	


	
}