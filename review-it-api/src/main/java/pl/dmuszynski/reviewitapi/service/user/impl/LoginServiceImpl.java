package pl.dmuszynski.reviewitapi.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.dmuszynski.reviewitapi.dto.request.SignInRequestDto;
import pl.dmuszynski.reviewitapi.dto.response.JwtResponseDto;
import pl.dmuszynski.reviewitapi.model.user.User;
import pl.dmuszynski.reviewitapi.security.jwt.JwtTokenUtils;
import pl.dmuszynski.reviewitapi.service.user.LoginService;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {
    private final JwtTokenUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginServiceImpl(JwtTokenUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    @Override
    public JwtResponseDto signIn(SignInRequestDto signInDetails) {
        final Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInDetails.getUsername(), signInDetails.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final User userPrincipal = (User) authentication.getPrincipal();
        final Set<String> authorities = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        final String accessToken = jwtUtils.generateJwtToken(authentication);

        System.out.println(authorities);
        return new JwtResponseDto.Builder(userPrincipal.getUsername(), accessToken, authorities)
                .build();
    }
}
