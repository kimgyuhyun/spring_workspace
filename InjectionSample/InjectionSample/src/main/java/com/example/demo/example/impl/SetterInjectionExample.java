package com.example.demo.example.impl;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class SetterInjectionExample implements Example {
    /** 필드 */
    private SomeService someService;

    /** 세터 주입 */
    @Autowired
    public void setSomeService(SomeService someService) {
        this.someService = someService;
    }

    /** 실행 */
    public void run() {
        someService.doService();
    }
}
