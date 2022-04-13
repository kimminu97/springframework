package day2.review;

public class YourMemberServiceimp implements MemberService{

	private MemberDao dao;
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
