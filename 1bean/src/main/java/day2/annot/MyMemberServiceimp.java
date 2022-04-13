package day2.annot;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import day2.review.MemberDao;

import day2.review.MemberService;
@Component("myService")	//value 속성 생략, bean id "myService"로 변경
public class MyMemberServiceimp implements MemberService{
//	@Autowired
//	@Qualifier("jdbcMemberDao")	오류 : 기본생성자 있을 때만
	private MemberDao dao;
	//사용할 수 있는(의존관계) 클래스는 MemberDao의 구현체로 합니다.
		//해당클래스는 Mybatis~Dao, Jdbc~Dao 클래스 2개
	
	public MyMemberServiceimp(@Qualifier("jdbcMemberDao")MemberDao dao) {
		System.out.println("MyMemberServiceImpl create /////");
		this.dao=dao;
	}
	
	public void setDao(MemberDao dao) {	//의존관계주입 setter
		this.dao = dao;
	}
	
	@Override
	public void find(int idx) {
		//예) 검색 비지니스 로직 처리 : My 방식으로
		System.out.println("My Logic~~~~");
		dao.find(idx);
	}

}
