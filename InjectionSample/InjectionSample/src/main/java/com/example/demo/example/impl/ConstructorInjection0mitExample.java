package com.example.demo.example.impl;
//생성자 주입(애너테이션 없음)
import com.example.demo.example.Example;
import com.example.demo.service.SomeService;
import org.springframework.stereotype.Component;

//@Component
public class ConstructorInjection0mitExample implements Example {
    /** 필드 */
    private final SomeService someService;

    /** 생성자 주입 */ //생성자가 하나뿐일 경우 @Autowired 생략 가능
    public ConstructorInjection0mitExample(SomeService someService) {
        this.someService = someService;
    }
    public void run() {
        someService.doService();
    }
}
