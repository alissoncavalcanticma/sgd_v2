package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.Domain;
import br.com.alstwo.sgd.repository.DomainRepository;
import br.com.alstwo.sgd.services.DomainService;
import br.com.alstwo.sgd.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        System.out.printf("ID: %s | ACTIVE: %s | GROUP: %s%n", id, active, group);
        return domainRepository.findByAllFilters(id, active, group).orElseThrow(() -> new ObjectNotFoundException("Domínio não encontrado."));
    }
}
