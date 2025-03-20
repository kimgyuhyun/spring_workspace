package com.example.demo.example.impl;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;
import org.springframework.stereotype.Component;

//@Component
public class ConstructorInjectionExample implements Example {
    /** 필드 */
    private final SomeService someService;

    /** 생성자 주입 */
    public ConstructorInjectionExample(SomeService someService) {
        this.someService = someService;
    }
    /** 실행 */
    public void run() {
        someService.doService();
    }
}
