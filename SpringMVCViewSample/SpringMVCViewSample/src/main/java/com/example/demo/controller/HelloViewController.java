package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloViewController {

    @GetMapping("view") //@RequestMapping의 Get 요청에 대한 애너테이션
    public String helloview() {
        //반환값으로 뷰 이름을 반환
        return "hello";
    }
    
    @GetMapping("model")
    public String helloview(Model model) {
        // Model에 데이터를 저장
        model.addAttribute("msg", "타임리프!!!");
        // 반환값으로 뷰 이름을 반환
        return "helloThymeleaf";
    }

    @GetMapping("modelandview")
    public ModelAndView helloview2(ModelAndView modelAndView) { //ModelAndView를 인수로 설정하면 스프링이 이 객체를 자동으로 생성
        //데이터 저장
        modelAndView.addObject("msg", "타임리프!!!"); //ModelAndView 객체에 뷰에 표시할 값을 추가합니다. msg라는 이름으로 '타임리프!!!'라는 값을 설정했습니다
        //화면 설정
        modelAndView.setViewName("helloThymeleaf"); //표시할 뷰(HTML 파일)을 지정합니다. 이 예제에서는 방금 생성한 helloThymeleaf.html이라는 이름의 뷰를 설정합니다.
        return modelAndView; //앞에서 설정한 ModelANdVIew 객체를 반환 그러면 지정한 뷰에 설정한 데이터가 전달되어 표시
    }
}
