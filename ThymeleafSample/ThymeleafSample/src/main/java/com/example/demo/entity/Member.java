package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
    /** 회원 ID */
    private Integer id;
    /** 회원명 */
    private String name;
}
