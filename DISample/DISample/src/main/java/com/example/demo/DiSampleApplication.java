package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.used.Greet;
/**
 * 스프링 부트 시작 클래스
 */
@SpringBootApplication
public class DiSampleApplication {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DiSampleApplication.class, args)
		.getBean(DiSampleApplication.class).execute(); // 자신의 execute 메서드를 호출하도록 작성
	}

	/** 주입되는 부분(인터페이스) */
	@Autowired  //사용하는 쪽에서 사용되는 쪽 인터페이스인 Greet을 필드로 선언
	private Greet g; //인터페이스 클래스 타입으로 참조변수 만들어놓으면 Component 부여해둔 클래스가 참조되는듯

	/**
	 * 실행
	 */
	private void execute() { //사용되는 쪽 인터페이슨 Greet의 greeting 메서드를 실행하는 메서드를 만듬
		String msg = g.greeting();
		System.out.println(msg);
	}
}
