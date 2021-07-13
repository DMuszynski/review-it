package pl.dmuszynski.reviewitapi.service.user;

import pl.dmuszynski.reviewitapi.dto.request.SignUpRequestDto;

public interface RegisterService {
    void signUp(SignUpRequestDto signUpDetails);
    //void activateAccountByTokenValue(String tokenValue);
}
