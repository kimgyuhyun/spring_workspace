package com.example.demo.aop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //@Before("execution(* com.example.demo.service.TargetService.*(..))") //시작되기전
    public void beforeAdvice(JoinPoint joinpoint) {
        LocalDateTime startTime =  LocalDateTime.now(); //현재 날짜 및 시간 가져오기
        String formattedTime = startTime.format(DateTimeFormatter.ofPattern("HH:mm:ss:SSS:SSS"));
        System.out.println("-------【@Before】-------");
        System.out.println("Before method : " + joinpoint.getSignature());
        System.out.println("메서드 시작: " + formattedTime);
    }

    //@After("execution(* com.example.demo.service.TargetService.*(..))") //종료된 후 실패 여부 관계없이 추가 처리 내용을 수행
    public  void afterAdvice(JoinPoint joinpoint) {
        LocalDateTime endTIme = LocalDateTime.now(); // 현재 날짜 및 시간 가져오기
        String formattedTime = endTIme.format(DateTimeFormatter.ofPattern("HH:m:ss:SSS"));
        System.out.println("-------【@After】-------");
        System.out.println("After method : " + joinpoint.getSignature());
        System.out.println("메서드 종료: " + formattedTime);
    }

     @Around("execution(* com.example.demo.service.TargetService.*(..))") //중심적 관심사의 '전후'로 추가 처리 내용을 수행
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTIme = System.currentTimeMillis();
        System.out.println("-------【@Around : 전】-------");
        System.out.println("■Target");
        System.out.println(" 클래스:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println(" 메서드:" + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed(); // 실행 메서드 호출

        System.out.println("-------【@Around : 후】-------");
        long elapsedTime = System.currentTimeMillis() - startTIme;
        System.out.println("메서드 실행 시간: " + elapsedTime + " milliseconds.");
        return result;
    }
}

//여기 안나오는 어드바이스
//@AfterReturning : 중심적 관심사가 '성공적으로 완료된 후' 추가 처리 내용을 수행
//@AfterThrowing : 중심적 관심사에서 '예외 발생 시' 추가 처리 내용을 수행
