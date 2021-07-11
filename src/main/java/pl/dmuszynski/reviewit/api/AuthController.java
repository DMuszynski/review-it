package pl.dmuszynski.reviewit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dmuszynski.reviewit.dto.request.SignUpRequestDto;
import pl.dmuszynski.reviewit.service.user.RegisterService;

@RestController
@RequestMapping(value = "/review-it/account")
public class AuthController {
    private final RegisterService registerService;

    @Autowired
    public AuthController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping(value = "/sign-up")
    public HttpStatus signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        this.registerService.signUp(signUpRequestDto);
        return HttpStatus.CREATED;
    }
}
