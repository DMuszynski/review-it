package pl.dmuszynski.reviewitapi.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dmuszynski.reviewitapi.dto.request.SignUpRequestDto;
import pl.dmuszynski.reviewitapi.model.user.Authority;
import pl.dmuszynski.reviewitapi.model.user.AuthorityType;
import pl.dmuszynski.reviewitapi.model.user.User;
import pl.dmuszynski.reviewitapi.repository.user.AuthorityRepository;
import pl.dmuszynski.reviewitapi.repository.user.UserRepository;
import pl.dmuszynski.reviewitapi.service.user.AuthorityService;
import pl.dmuszynski.reviewitapi.service.user.RegisterService;

import java.util.Collections;
import java.util.Set;

@Service(value = "registerService")
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                               AuthorityService authorityService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
    }

    @Override
    public void signUp(SignUpRequestDto signUpDetails) {
        final String encodedPassword = this.passwordEncoder.encode(signUpDetails.getPassword());
        final Set<Authority> authorities = Collections.singleton(this.authorityService
                .findByAuthorityType(AuthorityType.USER));

        this.userRepository.save(new User.Builder(signUpDetails.getEmail(), signUpDetails.getUsername(),
                encodedPassword, authorities).build());
    }

//    @Override
//    public void activateAccountByTokenValue(String tokenValue) {
//
//    }
}
