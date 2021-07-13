package pl.dmuszynski.reviewit.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWT;
import pl.dmuszynski.reviewit.model.user.User;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtTokenUtils {
    private final String jwtSecret = "SECRET";

    public String generateJwtToken(Authentication authentication) {
        final Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        final User userPrincipal = (User) authentication.getPrincipal();

        return JWT.create()
                .withIssuer("auth0")
                .withSubject(userPrincipal.getUsername())
                .withIssuedAt(Date.from(Instant.now()))
                .withExpiresAt(Date.from(Instant.now().plus(1, ChronoUnit.MINUTES)))
                .sign(algorithm);
    }

    public String getUsernameFromJwtToken(String token) {
        return JWT.decode(token).getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        final Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        try {
            final JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();

            jwtVerifier.verify(authToken);
            return true;
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Unauthorized exception");
        }
    }
}
