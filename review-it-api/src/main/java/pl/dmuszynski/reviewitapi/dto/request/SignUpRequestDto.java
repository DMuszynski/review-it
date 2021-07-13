package pl.dmuszynski.reviewitapi.dto.request;

import java.io.Serializable;

public class SignUpRequestDto implements Serializable {
    private final String email;
    private final String username;
    private final String password;

    public SignUpRequestDto(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
