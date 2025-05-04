package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.Domain;
import br.com.alstwo.sgd.repository.DomainRepository;
import br.com.alstwo.sgd.services.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DomainServiceImpl implements DomainService {

    private final DomainRepository domainRepository;

    @Override
    public Domain create(Domain domain) {
        return null;
    }

    @Override
    public Domain update(Domain domain) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Domain> findByAllFilters(Long id, Integer active, String group) {
        return domainRepository.findByAllFilters(id, active, group);
    }
}
