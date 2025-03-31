package com.example.webapp.controller;

import com.example.webapp.form.ToDoForm;
import com.example.webapp.helper.ToDoHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.ToDo;
import com.example.webapp.service.ToDoService;

import lombok.RequiredArgsConstructor;


/**
 * ToDo : 컨트롤러
 */
@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {
    /** DI */
    private final ToDoService toDoService;

    /**
     * '할일' 목록을 표시합니다.
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("todos", toDoService.findAllToDo());
        return "todo/list";
    }

    /**
     * 특정 ID의 '할일'에 대한 세부 정보를 표시합니다.
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model,
            RedirectAttributes attributes) {
        // 특정 ID에 해당하는 '할일' 정보를 획득
        ToDo ToDo = toDoService.findByIdToDo(id);
        if (ToDo != null) {
            // 대상 데이터가 있는 경우 모델에 저장
            model.addAttribute("todo", toDoService.findByIdToDo(id));
            return "todo/detail";
        } else {
            // 대상 데이터가 없는 경우 플래시 메시지 설정
            attributes.addFlashAttribute("errorMessage", "대상 데이터가 없습니다.");
            // 리디렉션
            return "redirect:/todos";
        }
    }

    // === 등록 및 업데이트 처리 추가 ===
    /**
     * 새 할일 등록 화면을 표시합니다.
     */
    @GetMapping("/form")
    public String newToDo(@ModelAttribute ToDoForm form) {
        // 새 할일 등록 화면 설정
        form.setIsNew(true);
        return "todo/form";
    }

    /**
     * 새 할일을 등록합니다.
     */
    @PostMapping("/save")
    public String create(@Validated ToDoForm form,
                         BindingResult bindingResult,
                         RedirectAttributes attributes) {
        // === 유효성 검사 ===
        // 입력 체크 NG: 입력 화면 표시
        if (bindingResult.hasErrors()) {
            // 새 할일 등록 화면 설정
            form.setIsNew(true);
            return "todo/form";
        }
        // 엔티티로 변환
        ToDo ToDo = ToDoHelper.convertToDo(form);
        // 등록 실행
        toDoService.insertToDo(ToDo);
        // 플래시 메시지
        attributes.addFlashAttribute("message", "새 ToDo가 생성됐습니다.");
        // RPG 패턴
        return "redirect:/todos";
    }

    /**
     * 특정 ID의 수정 화면을 표시합니다.
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model,
                       RedirectAttributes attributes) {
        // ID에 해당하는 할일을 가져옵니다.
        ToDo target = toDoService.findByIdToDo(id);
        if (target != null) {
            // 대상 데이터가 있는 경우 폼으로 변환
            ToDoForm form = ToDoHelper.convertToDoForm(target);
            // 모델에 저장
            model.addAttribute("toDoForm", form);
            return "todo/form";
        } else {
            // 대상 데이터가 없는 경우 플래시 메시지를 설정
               attributes.addFlashAttribute("errorMessage", "대상 데이터가 없습니다.");
               // 목록 화면으로 리디렉션
            return "redirect:/todos";
        }
    }

    /**
     * 할일을 업데이트합니다.
     */
    @PostMapping("/update")
    public String update(@Validated ToDoForm form,
                         BindingResult bindingResult,
                         RedirectAttributes attributes) {
        // === 유효성 검사 ===
        // 입력 체크 NG: 입력 화면 표시
        if (bindingResult.hasErrors()) {
            // 업데이트 화면 설정
            form.setIsNew(false);
            return "todo/form";
        }
        // 엔티티로 변환
        ToDo ToDo = ToDoHelper.convertToDo(form);
        // 할일 업데이트
        toDoService.updateToDo(ToDo);
        // 플래시 메시지
        attributes.addFlashAttribute("message", "ToDo가 업데이트됐습니다.");
        // PRG 패턴
        return "redirect:/todos";
    }

    /**
     * 특정 ID의 할일을 삭제합니다.
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        // 삭제 처리
        toDoService.deleteToDo(id);
        // 플래시 메시지
        attributes.addFlashAttribute("message", "ToDo가 삭제됐습니다.");
        // PRG 패턴
        return "redirect:/todos";
    }
}
