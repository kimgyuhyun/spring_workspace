package com.example.demo;

import com.example.demo.example.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InjectionSampleApplication {
	/** 시작 */
	public static void main(String[] args) {
		SpringApplication.run(InjectionSampleApplication.class, args)
				.getBean(InjectionSampleApplication.class).exe();
	}

	/** DI */
	@Autowired
	private Example example;

	/** 실행 */
	private void exe() {
		example.run();
	}

}
