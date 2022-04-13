package day2.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.testController;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext
				("classpath:META-INF/spring/testContext.xml");
		
		testController controller=(testController) context.getBean("testController");
		controller.find(20);
	}

}
