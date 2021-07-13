package pl.dmuszynski.reviewit.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmuszynski.reviewit.model.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
