package test;

import org.springframework.stereotype.Component;

import day2.review.MemberDao;
@Component
public class testdao implements MemberDao{

	public testdao() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void find(int idx) {
		System.out.println("testdao conn " + idx);
	}
	
}
