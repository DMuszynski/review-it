package pl.dmuszynski.reviewitapi.service.user;

import pl.dmuszynski.reviewitapi.dto.request.SignInRequestDto;
import pl.dmuszynski.reviewitapi.dto.response.JwtResponseDto;

public interface LoginService {
    JwtResponseDto signIn(SignInRequestDto signInRequestDto);
}
