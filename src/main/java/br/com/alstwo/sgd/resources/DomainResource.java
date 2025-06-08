package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.Domain;
import br.com.alstwo.sgd.domain.dto.DomainDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DomainResource {

    @PostMapping
    ResponseEntity<DomainDTO> create(DomainDTO domain);

    @GetMapping
    ResponseEntity<List<DomainDTO>> findByAllFilters(Long id, Boolean  active, String group);

    @PatchMapping(value = "/{id}")
    ResponseEntity<DomainDTO> update(Long id, DomainDTO domain);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Object> delete(Long id);
}
