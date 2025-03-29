package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.ToDo;

/**
 * ToDo; 서비스
 */
public interface ToDoService {

    /**
     * 모든 '할일'을 조회합니다.
     */
    List<ToDo> findAllToDo();

    /**
     * 특정 ID의 '할일'을 조회합니다.
     */
    ToDo findByIdToDo(Integer id);

    /**
     * '할일'을 새로 등록합니다.
     */
    void insertToDo(ToDo toDo);

    /**
     * '할일'을 업데이트합니다.
     */
    void updateToDo(ToDo toDo);

    /**
     * 특정 ID의 '할일'을 삭제합니다.
     */
    void deleteToDo(Integer id);
}
