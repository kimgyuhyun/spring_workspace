package utility;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 해시화된 문자열을 반환하는 클래스
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        // BCrypt 인스턴스화
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 입력값
        String rawPassword = "userpass";
        // 비밀번호 해시화
        String encodePassword = encoder.encode(rawPassword);
        // 출력
        System.out.println("해시화된 비밀번호:" + encodePassword);
    }
}
