package day.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day1.review.BuyController;

public class SpringApp {
	public static void main(String[] args) {
		//빈설정 파일을 읽어와서 빈(객체)를 생성합니다.	spring-context가 빈을 관리합니다.
		ApplicationContext context =
				new ClassPathXmlApplicationContext
				("classpath:META-INF/spring/applicationContext.xml");
		//위에서 만들어진 bean(객체) 중에서 id가 controller인 bean을 가져아 변수에 참조
		//getBean 메소드 리턴타입이 Object -> 참조변수에 맞게 캐스팅 필요
		BuyController controller = 
				(BuyController)context.getBean("controller");
		
		controller.buy();
		
	}
}
