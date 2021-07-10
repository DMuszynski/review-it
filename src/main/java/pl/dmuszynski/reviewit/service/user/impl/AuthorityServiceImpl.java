package pl.dmuszynski.reviewit.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.reviewit.model.user.Authority;
import pl.dmuszynski.reviewit.model.user.AuthorityType;
import pl.dmuszynski.reviewit.repository.user.AuthorityRepository;
import pl.dmuszynski.reviewit.service.user.AuthorityService;

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
