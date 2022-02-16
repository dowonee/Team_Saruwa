package project.saruwa;

public class srworderVO {
	private String ordercode;
	private String memid;
	private String address;
	private String pname;
	private String color;
	private String psize;
	private int cnt;
	private String orderdate;
	public srworderVO(String ordercode, String memid, String address, String pname, String color, String psize, int cnt,
			String orderdate) {
		this.ordercode = ordercode;
		this.memid = memid;
		this.address = address;
		this.pname = pname;
		this.color = color;
		this.psize = psize;
		this.cnt = cnt;
		this.orderdate = orderdate;
	}
	public srworderVO() {
		
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
}
