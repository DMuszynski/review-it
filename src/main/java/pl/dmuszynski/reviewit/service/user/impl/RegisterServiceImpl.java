package pl.dmuszynski.reviewit.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.reviewit.dto.request.SignUpRequestDto;
import pl.dmuszynski.reviewit.model.user.User;
import pl.dmuszynski.reviewit.repository.user.UserRepository;
import pl.dmuszynski.reviewit.service.user.RegisterService;

@Service(value = "registerService")
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(SignUpRequestDto signUpDetails) {

    }
}
