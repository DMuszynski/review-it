package pl.dmuszynski.reviewitapi.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.reviewitapi.model.user.Authority;
import pl.dmuszynski.reviewitapi.model.user.AuthorityType;
import pl.dmuszynski.reviewitapi.repository.user.AuthorityRepository;
import pl.dmuszynski.reviewitapi.service.user.AuthorityService;

@Service(value = "authorityService")
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authority findByAuthorityType(AuthorityType authorityType) {
        return this.authorityRepository.findByAuthorityType(authorityType)
                .orElseGet(() -> this.authorityRepository.save(new Authority(authorityType)));
    }
}
