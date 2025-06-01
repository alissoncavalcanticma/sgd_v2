package br.com.alstwo.sgd.services;

import br.com.alstwo.sgd.domain.Domain;

import java.util.List;
import java.util.Optional;

public interface DomainService {

    Domain create(Domain domain);
    Domain update(Domain domain);
    void delete(Long id);
    Domain findById(Long id);

    /*=====Aux Methods=======*/
    List<Domain>findByAllFilters(Long id, Integer active, String group);


}
