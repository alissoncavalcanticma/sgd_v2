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
       Optional<List<Domain>> dm = domainRepository.findByAllFilters(null, 1, domain.getGroup());
       if((!dm.get().isEmpty())){
           boolean result = dm.map(
                   lista -> lista.stream().anyMatch(x-> x.getCode().equals(domain.getCode()))
                            ).orElse(false);
           if(result == true) {
               return null;
           }
       }
       return domainRepository.save(domain);
    }

    @Override
    public Domain update(Domain domain) {
        Optional<List<Domain>> dm = domainRepository.findByAllFilters(domain.getId(), null, null);
        if(!dm.get().isEmpty()){
            return domainRepository.save(domain);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<List<Domain>> dm = domainRepository.findByAllFilters(id, null, null);
        if(!dm.get().isEmpty()){
            domainRepository.deleteById(id);
        }else{
            throw new ObjectNotFoundException("Id informado não existe");
        }
    }

    @Override
    public List<Domain> findByAllFilters(Long id, Integer active, String group) {
        System.out.printf("ID: %s | ACTIVE: %s | GROUP: %s%n", id, active, group);
        return domainRepository.findByAllFilters(id, active, ((group != null)? "%"+ group + "%" : group)).orElseThrow(() -> new ObjectNotFoundException("Domínio não encontrado."));
    }
}

