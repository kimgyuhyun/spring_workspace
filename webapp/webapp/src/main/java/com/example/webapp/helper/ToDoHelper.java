package com.example.webapp.helper;


import com.example.webapp.entity.ToDo;
import com.example.webapp.form.ToDoForm;

/**
 * ToDo: 헬퍼
 */
public class ToDoHelper {
    /**
     * ToDo로 변환
     */
    public static ToDo convertToDo(ToDoForm form) {
        ToDo todo = new ToDo();
        todo.setId(form.getId());
        todo.setTodo(form.getTodo());
        todo.setDetail(form.getDetail());
        return todo;
    }

    /**
     * ToDoForm 으로 변환
     */
    public static ToDoForm convertToDoForm(ToDo toDo) {
        ToDoForm form = new ToDoForm();
        form.setId(toDo.getId());
        form.setTodo(toDo.getTodo());
        form.setDetail(toDo.getDetail());
        // 업데이트 화면 설정
        form.setIsNew(false);
        return form;
    }
}
