package test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import day2.review.MemberService;
@Component
public class testController {
	private MemberService service;
	
	public testController(@Qualifier("myService") MemberService service) {
		System.out.println("testController~~");
		this.service=service;
	}
	
	public void find(int idx) {
		System.out.println("MemberController find");
		service.find(idx);
	}
}
