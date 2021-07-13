package pl.dmuszynski.reviewit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dmuszynski.reviewit.dto.request.SignInRequestDto;
import pl.dmuszynski.reviewit.dto.request.SignUpRequestDto;
import pl.dmuszynski.reviewit.dto.response.JwtResponseDto;
import pl.dmuszynski.reviewit.service.user.LoginService;
import pl.dmuszynski.reviewit.service.user.RegisterService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/review-it/account")
public class AuthController {
    private final LoginService loginService;
    private final RegisterService registerService;

    @Autowired
    public AuthController(LoginService loginService, RegisterService registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @PostMapping(value = "/sign-up")
    public HttpStatus signUp(@RequestBody @Valid SignUpRequestDto signUpRequestDto) {
        this.registerService.signUp(signUpRequestDto);
        return HttpStatus.CREATED;
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody @Valid SignInRequestDto signInRequestDto) {
        final JwtResponseDto jwtResponseDto = this.loginService.signIn(signInRequestDto);
        return new ResponseEntity<>(jwtResponseDto, HttpStatus.OK);
    }
}
