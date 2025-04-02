package com.example.webapp.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 사용자의 인증 정보를 나타내는 UserDetails 구현 클래스
 */
public class LoginUser extends User {
    /** 최소한의 정보만 담은 UserDetails 구현 클래스인
     * Useer 를 생성 */
    public LoginUser(String username,
                     String password,
                     Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
