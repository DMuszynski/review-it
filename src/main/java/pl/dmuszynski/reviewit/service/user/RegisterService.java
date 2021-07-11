package pl.dmuszynski.reviewit.service.user;

import pl.dmuszynski.reviewit.dto.request.SignUpRequestDto;

public interface RegisterService {
    void signUp(SignUpRequestDto signUpDetails);
    //void activateAccountByTokenValue(String tokenValue);
}
