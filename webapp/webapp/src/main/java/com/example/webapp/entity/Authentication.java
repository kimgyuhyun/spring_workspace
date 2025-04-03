package com.example.webapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authentication {
    /** 사용자명 */
    private String username;
    /** 비밀번호 */
    private String password;
    /** 권한 */
    private Role authority;
    /** 표시명 */
    private String displayname;
}
