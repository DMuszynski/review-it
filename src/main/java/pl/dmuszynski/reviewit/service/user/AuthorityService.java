package pl.dmuszynski.reviewit.service.user;

import pl.dmuszynski.reviewit.model.user.Authority;
import pl.dmuszynski.reviewit.model.user.AuthorityType;

public interface AuthorityService {
    Authority findByAuthorityType(AuthorityType authorityType);
}
