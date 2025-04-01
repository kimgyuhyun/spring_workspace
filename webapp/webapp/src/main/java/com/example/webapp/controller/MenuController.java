package com.example.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Menu: 컨트롤러
 */
@Controller
@RequestMapping("/")
public class MenuController {
    /**
     * 메뉴 화면 표시
     */
    @GetMapping
    public String showMenu() {
        // teplates 폴더 아래의 menu.html로 전환
        return "menu";
    }
}
