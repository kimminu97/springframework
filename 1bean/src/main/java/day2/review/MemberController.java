package day2.review;

public class MemberController {
	private MemberService service;
	//사용할 수 있는(의존관계) 클래스는 MemberSerivce의 구현체로 합니다.
	//해당클래스는 Your~impl, My~impl 클래스 2개
	
	public MemberController(MemberService service) {
		System.out.println("MemberController create /////");
		this.service=service;
	}
	public void find(int idx) {
		System.out.println("MemberController find~~~~");
		service.find(idx);
	}
}
