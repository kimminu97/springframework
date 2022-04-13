package test;

import org.springframework.stereotype.Component;

import day2.review.MemberDao;
//@Component
public class yourService implements MemberDao{
	private MemberDao dao;
	
	public yourService(MemberDao dao) {
		System.out.println("yourService!!");
		this.dao=dao;
	}
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
 @Override
public void find(int idx) {
	 System.out.println("yourservice find");
}
}
