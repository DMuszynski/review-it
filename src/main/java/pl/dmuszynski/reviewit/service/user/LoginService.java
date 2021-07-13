package pl.dmuszynski.reviewit.service.user;

import pl.dmuszynski.reviewit.dto.request.SignInRequestDto;
import pl.dmuszynski.reviewit.dto.response.JwtResponseDto;

public interface LoginService {
    JwtResponseDto signIn(SignInRequestDto signInRequestDto);
}
