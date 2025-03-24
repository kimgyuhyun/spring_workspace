package com.example.demo.controller;

import com.example.demo.form.SampleForm;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Controller
public class RequestParamMultipleController {

    //GET 및 URL(/multiple)
    @GetMapping("multiple")
    public String showView() {
        // 반환값으로 뷰 이름을 반환
        return "entry";
    }

//    //POST 및 URL(/confirm)
//    @PostMapping("confirm")
//    public String confirmView(Model model,
//                              @RequestParam String name,
//                              @RequestParam Integer age,
//                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate birth) {
//        // Model에 저장
//        model.addAttribute("name", name);
//        model.addAttribute("age", age);
//        model.addAttribute("birth", birth);
//        // 반환값으로 뷰 이름을 반환
//        return "confirm";
//    }
    // POST 및 URL(/confirm)
    @PostMapping("confirm")
    public String confirmView(SampleForm f) {
        // 반환값으로 뷰 이름을 반환
        return "confirm2";
    }
}
