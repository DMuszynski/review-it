package pl.dmuszynski.reviewitapi.dto.request;

import java.io.Serializable;

public class SignInRequestDto implements Serializable {
    private final String username;
    private final String password;

    public SignInRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
