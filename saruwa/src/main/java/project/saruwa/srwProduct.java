package project.saruwa;

public class srwProduct {
	private String pcode; // 상품코드
	private String pname; // 상품명
	private String pbrand; // 브랜드명
	private String color; // 컬러
	private String price; // 가격
	private String price2; // 가격순
	private String size; //사이즈
	private String pdate; // 입고날짜
	private int tolcnt; // 판매량
	public srwProduct() {
	}
	
	
	

	public srwProduct(String pcode, String pname, String pbrand, String color, String price, String size,
			String pdate) {
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.pbrand = pbrand;
		this.color = color;
		this.price = price;
		this.size = size;
		this.pdate = pdate;
	}




	public srwProduct(String pcode, String pname, String pbrand, String color, String price, String pdate, int tolcnt) {
		this.pcode = pcode;
		this.pname = pname;
		this.pbrand = pbrand;
		this.color = color;
		this.price = price;
		this.pdate = pdate;
		this.tolcnt = tolcnt;
	}




	public srwProduct(String pcode, String pname, String pbrand, String color, String price, String size, String pdate,
			int tolcnt) {
		this.pcode = pcode;
		this.pname = pname;
		this.pbrand = pbrand;
		this.color = color;
		this.price = price;
		this.size = size;
		this.pdate = pdate;
		this.tolcnt = tolcnt;
	}




	public srwProduct(String pcode, String price, String price2, String pdate) {
		this.pcode = pcode;
		this.price = price;
		this.price2 = price2;
		this.pdate = pdate;
	}




	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public srwProduct(String pcode) {
		this.pcode = pcode;
	}


	public String getPcode() {
		return pcode;
	}


	public void setPcode(String pcode) {
		this.pcode = pcode;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPbrand() {
		return pbrand;
	}


	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getPrice2() {
		return price2;
	}


	public void setPrice2(String price2) {
		this.price2 = price2;
	}


	public String getPdate() {
		return pdate;
	}


	public void setPdate(String pdate) {
		this.pdate = pdate;
	}


	public int getTolcnt() {
		return tolcnt;
	}


	public void setTolcnt(int tolcnt) {
		this.tolcnt = tolcnt;
	}

	
	
}
