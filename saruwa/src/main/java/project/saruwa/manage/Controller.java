package project.saruwa.manage;


import java.util.Scanner;

public class Controller {
	Service s = new Service();
	Scanner sc = new Scanner(System.in);

	// 로그인
	public String login(Model d) {
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String pass = sc.nextLine();
		d.addAttribute("로그인", s.login(id, Integer.parseInt(pass)));
		return "main.jsp";
	}
	
	// 회원정보 통계 - 최근회원가입자 정보
	public String thisWeekMemberInfo(Model d) {
		d.addAttribute("최근회원가입자 정보", s.thisWeekMemberInfo());
		return "member.jsp";
	}

	// 회원정보 통계
	public String total(Model d) {
		d.addAttribute("최근회원가입자 정보", s.total());
		return "member.jsp";
	}
	// 회원정보 나열/정렬
	public String memberInfo(Model d) {
		System.out.print("정렬방식: ");
		String choice = sc.nextLine();
		d.addAttribute("회원정보", s.memberInfo(choice));
		return "member.jsp";
	}
}
