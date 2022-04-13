package day4.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import day4.dto.BookRentDto;
import day4.service.BookRentService;
import day4.service.BookService;
import day4.service.MemberService;

//main 메소드에서 했던 코딩 테스트를 여기서 하는 것이 옳습니다.
@ExtendWith(SpringExtension.class)	//spring-test를 사용해서 bean에 접근하기 위함입니다.
@ContextConfiguration(locations= {"classpath:META-INF/spring/applicationContext.xml"})
class BookRentTest {
	@Autowired
	BookRentService rentservice;
	
	@Autowired
	BookService bookService;

	@Autowired
	MemberService memberService;
	
	@Autowired
	ApplicationContext context;
	
	//@Test	//테스트 결과는 성공 또는 실패
	void test() {	//테스트를 위한 전용 메소드들 중 하나 fail(실패), 실행해서 테스트할 메소드에 모두 표시가능
		fail("Not yet implemented");
	}
	@Test
	void rentServiceTest() {
		assertNotNull(rentservice); 	//rentService 객체가 not null이면 성공
		BookRentDto dto = BookRentDto.builder()
				.bcode("T1234").mem_idx(10002)
				.build();
		int result = rentservice.insert(dto);
		assertEquals(result, 1);	//result 값이 1이면 성공
	}
	void sqlSessionTest() {
		SqlSessionTemplate sqlSession = 
				(SqlSessionTemplate) context.getBean("sqlSessionTemplate");
		assertNotNull(sqlSession);

	}

}
