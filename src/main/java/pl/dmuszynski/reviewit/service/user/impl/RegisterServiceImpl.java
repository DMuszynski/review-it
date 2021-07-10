package pl.dmuszynski.reviewit.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dmuszynski.reviewit.dto.request.SignUpRequestDto;
import pl.dmuszynski.reviewit.model.user.Authority;
import pl.dmuszynski.reviewit.model.user.AuthorityType;
import pl.dmuszynski.reviewit.model.user.User;
import pl.dmuszynski.reviewit.repository.user.AuthorityRepository;
import pl.dmuszynski.reviewit.repository.user.UserRepository;
import pl.dmuszynski.reviewit.service.user.RegisterService;

import java.util.Collections;
import java.util.Set;

@Service(value = "registerService")
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                               AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void signUp(SignUpRequestDto signUpDetails) {
        final String encodedPassword = this.passwordEncoder.encode(signUpDetails.getPassword());
        //final Set<Authority> authorities = Collections.singleton(this.authorityRepository.findByAuthorityType(AuthorityType.USER).orE);
        //this.userRepository.save(new User.Builder(signUpDetails.getEmail(), signUpDetails.getUsername(), encodedPassword))
    }
}
