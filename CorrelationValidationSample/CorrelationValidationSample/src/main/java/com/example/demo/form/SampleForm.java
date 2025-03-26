package com.example.demo.form;

import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

import java.util.Objects;

@Data
public class SampleForm {
    /** 비밀번호 */
    private String password;
    /** 확인용 비밀번호 */
    private String confirmPassword;

    //비밀번호와 확인용 비밀번호가 일치하는지 확인
    @AssertTrue(message = "비밀번호가 일치하지 않습니다.")
    public boolean isSamePassword() {
        return Objects.equals(password, confirmPassword);
    }
}