package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.Domain;
import br.com.alstwo.sgd.resources.DomainResource;
import br.com.alstwo.sgd.services.DomainService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/api/domain")
@RestController
public class DomainResourceImpl implements DomainResource {

    private final DomainService domainService;

    @Override
    public ResponseEntity<List<Domain>> findByAllFilters(@RequestParam(required = false) Long id, @RequestParam(required = false) Boolean active, @RequestParam(required = false) String group) {

        List<Domain> domainList = domainService.findByAllFilters(id, ((active == true || active == null)? 1 : 0), group);
        if(domainList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(domainList.stream().toList());
    }
}
