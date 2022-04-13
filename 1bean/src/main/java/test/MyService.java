package test;

import org.springframework.stereotype.Component;

import day2.review.MemberDao;
import day2.review.MemberService;
@Component
public class MyService implements MemberService {
	
	private MemberDao dao;
	
	public MyService(MemberDao dao) {
		System.out.println("MyService ~~");
		this.dao=dao;
	}
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	@Override
	public void find(int idx) {
		
		System.out.println("myservice find");
		dao.find(idx);
	}
}
