package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.Domain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DomainResource {

    @PostMapping
    ResponseEntity<Domain> create(Domain domain);

    @GetMapping
    ResponseEntity<List<Domain>> findByAllFilters(Long id, Boolean  active, String group);

    @PatchMapping(value = "/{id}")
    ResponseEntity<Domain> update(Long id, Domain domain);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Object> delete(Long id);
}
