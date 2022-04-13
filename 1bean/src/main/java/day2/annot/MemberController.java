package day2.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import day2.review.MemberService;

@Component	//bean id는 스프링컨테이너가 자동으로 memberController로 만듭니다.
public class MemberController {
//	@Autowired
//	@Qualifier("myMemberServiceimp")	오류 : 기본생성자 있을 때만 가능
	private MemberService service;
	//사용할 수 있는(의존관계) 클래스는 MemberSerivce의 구현체로 합니다.
	//해당클래스는 Your~impl, My~impl 클래스 2개
	
	//생성자 의존관계 자동주입 : 현재 MemberService 타입객체가 1개일때만
	//@Autowired 생략됨. 생성자에서만 생략합니다.
	public MemberController(@Qualifier("myService")MemberService service) {
		System.out.println("MemberController create /////");
		this.service=service;
	}
	public void find(int idx) {
		System.out.println("MemberController find~~~~");
		service.find(idx);
	}
}
