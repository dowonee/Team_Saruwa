package project.saruwa.manage;


import java.util.ArrayList;

import project.saruwa.Member;

public class Service {
	Dao d = new Dao();

	// 로그인
	public boolean login(String i, int p) {
		boolean result = d.login(i, p);
		if (result) {
			System.out.println("로그인 성공");
			return true;
		} else {
			System.out.println("로그인 실패");
			return false;
		}
	}
	// 회원정보 통계 - 최근회원가입자 정보
	public String thisWeekMemberInfo() {
		ArrayList<Member> mlist = d.thisWeekMemberInfo();
		String result = "";
		System.out.println("가입날자\t아이디\t이메일\t동의여부");
		for(Member list:mlist) {
			if(list.getMrkAgree() == 1) {
				result = "동의";
			}else {
				result = "비동의";
			}
			System.out.print(list.getMdate()+"\t");
			System.out.print(list.getMemId()+"\t");
			System.out.print(list.getMemEmail()+"\t");
			System.out.println(result);
			System.out.println("-------------------------");
		}
		return "출력완료";
	}
	// 회원정보 통계
	public String total() {
		int[] list = d.total();
		System.out.println("신규회원\t주간회원\t탈퇴회원\t총 회원수");
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+"\t");
		}
		return "출력완료";
	}
	// 회원정보 나열/정렬
	public String memberInfo(String s) {
		if(s.equals("내림차순")) {
			s = "desc";
		}else if(s.equals("오름차순")) {
			s = "asc";
		}
		ArrayList<Member> mlist = d.memberInfo(s);
		String result = "";
		int i = 1;
		System.out.println("번호\t아이디\t이메일\t휴대폰번호\t동의여부\t가입날자");
		for(Member list:mlist) {
			if(list.getMrkAgree() == 1) {
				result = "동의";
			}else {
				result = "비동의";
			}
			StringBuffer phone = new StringBuffer(list.getPhoneNum());
			phone.insert(4, "-");
			System.out.print(i+"\t");
			System.out.print(list.getMemId()+"\t");
			System.out.print(list.getMemEmail()+"\t");
			System.out.print("010-"+phone+"\t");
			System.out.print(result+"\t");
			System.out.println(list.getMdate().substring(0,10));
			System.out.println("-------------------------");
			i++;
		}
		return "출력완료";
	}
}
