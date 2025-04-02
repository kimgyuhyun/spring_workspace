package com.example.webapp.repository;


import com.example.webapp.entity.Authentication;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthenticationMapper {

    /**
     * 사용자명으로 로그인 정보를 조회
     */
    Authentication selectByUsername(String username);
}
