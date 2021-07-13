package pl.dmuszynski.reviewitapi.service.user;

import pl.dmuszynski.reviewitapi.model.user.Authority;
import pl.dmuszynski.reviewitapi.model.user.AuthorityType;

public interface AuthorityService {
    Authority findByAuthorityType(AuthorityType authorityType);
}
