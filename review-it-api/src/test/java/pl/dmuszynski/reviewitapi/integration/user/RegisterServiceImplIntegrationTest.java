package pl.dmuszynski.reviewitapi.integration.user;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.dmuszynski.reviewitapi.service.user.RegisterService;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceImplIntegrationTest {
    @InjectMocks
    private RegisterService registerService;

}
