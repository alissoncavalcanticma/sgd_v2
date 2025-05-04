package br.com.alstwo.sgd.services;

import br.com.alstwo.sgd.domain.Domain;

import java.util.List;

public interface DomainService {
    //Domain findById(Long id);
    //List<Domain> findAll();
    Domain create(Domain domain);
    Domain update(Domain domain);
    void delete(Long id);

    /*=====Aux Methods=======*/
    List<Domain> findByAllFilters(Long id, Integer active, String group);


}
