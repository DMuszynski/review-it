package pl.dmuszynski.reviewitapi.dto.response;

import java.util.Set;

public class JwtResponseDto {
    private final String username;
    private final String accessToken;
    private final Set<String> authorities;

    public static class Builder {
        private final String username;
        private final String accessToken;
        private final Set<String> authorities;

        public Builder(String username, String accessToken, Set<String> authorities) {
            this.username = username;
            this.accessToken = accessToken;
            this.authorities = authorities;
        }

        public JwtResponseDto build() {
            return new JwtResponseDto(this);
        }
    }

    public JwtResponseDto(Builder builder) {
        this.username = builder.username;
        this.accessToken = builder.accessToken;
        this.authorities = builder.authorities;
    }

    public String getUsername() {
        return username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }
}
