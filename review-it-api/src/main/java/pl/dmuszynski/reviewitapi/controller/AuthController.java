package pl.dmuszynski.reviewitapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dmuszynski.reviewitapi.dto.request.SignInRequestDto;
import pl.dmuszynski.reviewitapi.dto.request.SignUpRequestDto;
import pl.dmuszynski.reviewitapi.dto.response.JwtResponseDto;
import pl.dmuszynski.reviewitapi.service.user.LoginService;
import pl.dmuszynski.reviewitapi.service.user.RegisterService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/review-it/account", produces = { MediaType.APPLICATION_JSON_VALUE })
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
