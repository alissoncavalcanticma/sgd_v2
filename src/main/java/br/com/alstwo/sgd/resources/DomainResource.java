package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.Domain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface DomainResource {

    @GetMapping
    ResponseEntity<List<Domain>> findByAllFilters(Long id, Boolean  active, String group);
}
