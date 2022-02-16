package project.saruwa;
import java.util.ArrayList;
import java.util.Random;


public class srwService {

	srwDao dao = new srwDao();
	
	//상품 필터 
	public String Profilter(String pcode,String price,String price2,String pdate) {
		ArrayList<srwProduct> list = dao.profilter(pcode,price,price2,pdate);
		for(srwProduct sl: list) {
			System.out.println("-----------------------------------------------");
			System.out.println("상품명: "+ sl.getPname());
			System.out.println("브랜드명: "+sl.getPbrand());
			System.out.println("색상: "+sl.getColor());
			System.out.println("가격: "+sl.getPrice());
			System.out.println("-----------------------------------------------");
			System.out.println("");
		}
		return "출력완료";
	}

	
	//베스트상품 리스트
	public String Bestlist() {
		ArrayList<srwProduct> list = dao.probest();
		for(srwProduct sl: list) {
			System.out.println("-----------------------------------------------");
			System.out.println("상품명: "+ sl.getPname());
			System.out.println("브랜드명: "+sl.getPbrand());
			System.out.println("색상: "+sl.getColor());
			System.out.println("가격: "+sl.getPrice());
			System.out.println("-----------------------------------------------");
			System.out.println("");
		}
		return "출력완료";
	}
	
	//상세페이지
	public srwProduct Detlist(String pname) {
		srwProduct list = dao.prodetl(pname);
			System.out.println("-----------------------------------------------");
			System.out.println("상품명: "+ list.getPname());
			System.out.println("브랜드명: "+list.getPbrand());
			System.out.println("색상: "+list.getColor());
			System.out.println("가격: "+list.getPrice());
			System.out.println("-----------------------------------------------");
			System.out.println("");
		ArrayList<srwProduct> slist = dao.psize(pname);
		for(srwProduct slt: slist) {
			System.out.println("옵션: "+ slt.getSize());
			System.out.println("");
		}
		
		
		return list;
	}
	
	//주문서페이지 - 주문하기
	public String orderlist(String id,String address,String size,int cnt,String pname,String color) {
		Random rand = new Random();
		String code = "";
		System.out.println("-----------------------------------------------");
		for(int i = 0 ; i <= 0 ; i++) {
		code = Integer.toString(rand.nextInt(99999999));
		System.out.println("주문번호 : " + code);}
		System.out.println("아이디: "+id);
		System.out.println("이름: "+pname);
		System.out.println("색상: "+color);
		System.out.println("사이즈: "+size);
		System.out.println("갯수: "+cnt);
		System.out.println("주소: "+address);
		System.out.println("-----------------------------------------------");
		System.out.println("");
		dao.sorder(code, id, address, size, cnt, pname, color);

		return "출력완료";
	}
	//장바구니
	public String basketlist(String id,String pname,String price,String color,String size,int cnt) {

		System.out.println("-----------------------------------------------");
		System.out.println("아이디: "+id);
		System.out.println("이름: "+pname);
		System.out.println("가격: "+price);
		System.out.println("색상: "+color);
		System.out.println("사이즈: "+size);
		System.out.println("갯수: "+cnt);
		System.out.println("-----------------------------------------------");
		System.out.println("");
		dao.sbasket(id, pname, price, color, size, cnt);

		return "출력완료";
	}
	
	//좋아요
	public String likelist(String id,String pname) {
		
		System.out.println("-----------------------------------------------");
		System.out.println("아이디: "+id);
		System.out.println("이름: "+pname);
		System.out.println("-----------------------------------------------");
		System.out.println("");
		dao.slike(id, pname);
		
		return "출력완료";
	}
	
	//비슷한 상품
		public String similarlist(String pname,String price, String pbrand, String color) {
			ArrayList<srwProduct> list = dao.similar(pname, price, pbrand, color);
			for(srwProduct sl: list) {
			System.out.println("-----------------------------------------------");
			System.out.println("이름: "+sl.getPname());
			System.out.println("가격: "+sl.getPrice());
			System.out.println("브랜드: "+sl.getPbrand());
			System.out.println("색상: "+sl.getColor());
			System.out.println("-----------------------------------------------");
			System.out.println("");
			}

			return "출력완료";
		}
	
}
