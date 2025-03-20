package com.example.demo.config;

import com.example.demo.service.BusinessLogic;
import com.example.demo.service.impl.SampleLogicImpl;

import com.example.demo.service.impl.TestLogicImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "test") //메서드가 빈을 반환한다는것을 나타냄
    public BusinessLogic dataLogic() {//빈의 내용 name 속성에서 설정한 test 는 TestLogicImpl 인스턴스를
        return new TestLogicImpl(); //DI 컨테이너에 test 라는 이름의 빈으로 등록하게 합니다.
    }

    @Bean(name = "sample")
    public BusinessLogic viewLogic() {
        return new SampleLogicImpl(); //DI 컨테이너에 sample 라는 이름의 빈으로 등록하게 합니다.
    }
}
