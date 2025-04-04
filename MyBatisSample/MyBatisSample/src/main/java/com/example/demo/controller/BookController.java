package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class BookController {
    // DI
    private final BookMapper bookMapper;

    // 메뉴 화면 표시
    @GetMapping("/")
    public String showIndex() {
        return "book/index";
    }

    // 모든 책 보기
    @GetMapping("/list")
    public String showAllBooks(Model model) {
        model.addAttribute("message", "목록 보기");
        model.addAttribute("books", bookMapper.getAllBooks());
        return "book/success";
    }

    // 특정 ID를 가진 책 가져오기
    @GetMapping("/detail/{id}")
    public String showBook(@PathVariable int id, Model model) {
        model.addAttribute("message", "상세 보기");
        model.addAttribute("book", bookMapper.getBookById(id));
        return "book/success";
    }

    // 새 책 만들기
    @GetMapping("/create")
    public String createBook(Model model) {
        // 등록용 더미 데이터
        Book book = new Book();
        book.setTitle("자바/스프링 개발자를 위한 실용주의 프로그래밍");
        book.setAuthor("김우근");
        bookMapper.insertBook(book);
        model.addAttribute("message", "등록 성공");
        return "book/success";
    }

    // 특정 ID를 가진 책 업데이트
    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable int id, Model model) {
        // 업데이트용 더미 데이터
        Book book = new Book();
        book.setId(id);
        book.setTitle("업데이트된 제목");
        book.setAuthor("업데이트된 저자");
        bookMapper.updateBook(book);
        model.addAttribute("message", "업데이트 성공");
        return "book/success";
    }

    // 특정 ID를 가진 책 삭제
    @GetMapping("/delete/{id}")
    public  String deleteBook(@PathVariable int id, Model model) {
        bookMapper.deleteBookById(id);
        model.addAttribute("message", "삭제 성공");
        return  "book/success";
    }
}
