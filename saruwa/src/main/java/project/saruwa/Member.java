package project.saruwa;

public class Member {
	private String memId;
	private String memPass;
	private String memEmail;
	private String phoneNum;
	private int mrkAgree;
	private String cerId;
	private String cerEmail;
	private String cerPhone;
	private String mdate;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String memId) {
		this.memId = memId;
	}

	public Member(String memId, String memPass, String memEmail, String phoneNum, int mrkAgree, String cerId,
			String cerEmail, String cerPhone) {
		super();
		this.memId = memId;
		this.memPass = memPass;
		this.memEmail = memEmail;
		this.phoneNum = phoneNum;
		this.mrkAgree = mrkAgree;
		this.cerId = cerId;
		this.cerEmail = cerEmail;
		this.cerPhone = cerPhone;
	}
	
	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getMrkAgree() {
		return mrkAgree;
	}
	public void setMrkAgree(int mrkAgree) {
		this.mrkAgree = mrkAgree;
	}
	public String getCerId() {
		return cerId;
	}
	public void setCerId(String cerId) {
		this.cerId = cerId;
	}
	public String getCerEmail() {
		return cerEmail;
	}
	public void setCerEmail(String cerEmail) {
		this.cerEmail = cerEmail;
	}
	public String getCerPhone() {
		return cerPhone;
	}
	public void setCerPhone(String cerPhone) {
		this.cerPhone = cerPhone;
	}
	

}
