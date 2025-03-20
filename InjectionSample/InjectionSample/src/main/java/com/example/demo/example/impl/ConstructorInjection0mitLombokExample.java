package com.example.demo.example.impl;
//생성자 주입(애너테이션 없음, 롬복)
import com.example.demo.example.Example;
import com.example.demo.service.SomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor//롬복 애너테이션중 하나 이걸 클래스에 부여하면 해당 클래스의 final 이 붙은 필드만
                        // 인수로 받는 생성자를 자동 생성함으로 직접 작성하는것을 생략 가능
public class ConstructorInjection0mitLombokExample implements Example {
    /** 필드 */
    private final SomeService someService;

    // 생성자 생략 가능

    /** 실행 */
    public void run() {
        someService.doService();
    }
}
