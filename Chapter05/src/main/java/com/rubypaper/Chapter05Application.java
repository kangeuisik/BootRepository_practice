package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter05Application {

	public static void main(String[] args) {
		SpringApplication application = 
new SpringApplication(Chapter05Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		//NONE으로 설정했기때문에 톰캣서버를 구동하지 않고 실행
		application.run(args);
	}
}
