package day2.annot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import day2.review.MemberDao;
import day2.review.MemberService;
@Component(value = "yourService") //bean id를 yourService로 지정
public class YourMemberServiceimp implements MemberService{
	@Autowired						//MemberDao 구현체 bean이 1개일때는 자동주입
	@Qualifier("mybatisMemberDao")	//MemberDao 구현체 bean이 2개이상일 때 bean 이름 설정
	private MemberDao dao;			//		ㄴ bean이름은 자동으로 클래스이름의 첫글자 소문자로 설정
	//사용할 수 있는(의존관계) 클래스는 MemberDao의 구현체로 합니다.
		//해당클래스는 Mybatis~Dao, Jdbc~Dao 클래스 2개
	
	
	public YourMemberServiceimp() {
		System.out.println("YourMemberServiceimp create");
		
	}
	public void setDao(MemberDao dao) {	//의존관계주입 setter
		this.dao = dao;
	}
	
	@Override
	public void find(int idx) {
		//예) 검색 비지니스 로직 처리 : Your 방식으로
		System.out.println("Your Logic ~~~~");
		dao.find(idx);
	}

}
