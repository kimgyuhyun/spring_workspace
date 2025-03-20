package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service // 스테레오타입 애너테이션을 부여해서 인스턴스 생성 대상으로 지정
public class TargetService {

    public void sayHello(String name) {
        System.out.println("안녕, " + name + "!");
    }

    public void sayGoodbye(String name) {
        System.out.println("잘가, " + name + "!");
    }
}
