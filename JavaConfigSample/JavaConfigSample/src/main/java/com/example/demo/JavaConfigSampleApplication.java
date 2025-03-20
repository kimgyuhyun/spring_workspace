package com.example.demo;

import com.example.demo.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaConfigSampleApplication {

	/** 시작 방법 */
	public static void main(String[] args) {
		SpringApplication.run(JavaConfigSampleApplication.class, args)
				.getBean(JavaConfigSampleApplication.class).exe();
	}

	//** DI */
	@Autowired
	@Qualifier("test") //@Bean 설정에서 이름이 test인 빈을 주입하라는 의미입니다.
	private  BusinessLogic business1; // TestLogicImpl 인스턴스가 business1에 주입됨

	//** DI */
	@Autowired
	@Qualifier("sample")
	private BusinessLogic business2; // SampllogicImpl 인스턴스

	/** 실행 방법 */
	public void exe() {
		business1.doLogic();
		business2.doLogic();
	}
}
