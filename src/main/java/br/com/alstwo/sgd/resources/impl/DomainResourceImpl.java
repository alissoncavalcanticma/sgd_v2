package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.Domain;
import br.com.alstwo.sgd.resources.DomainResource;
import br.com.alstwo.sgd.services.DomainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping(value = "${api.basePath}${api.domain.domain.path}")
@RestController
public class DomainResourceImpl implements DomainResource {

    private final DomainService domainService;

    @Override
    /* Anotações do Swagger */
    @Operation(summary = "Consulta de domínios", description = "Consulta de domínios por vários filtros", tags = "Domain")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna domínio"),
            @ApiResponse(responseCode = "400", description = "Erro ao consultar domínio")
        }
    )
    /* Anotações do Swagger */
    public ResponseEntity<List<Domain>> findByAllFilters(@RequestParam(required = false) Long id, @RequestParam(required = false) Boolean active, @RequestParam(required = false) String group) {

        List<Domain> domainList = domainService.findByAllFilters(id, (active != null) ? ((active == true)? 1 : 0) : null, group);
        if (domainList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(domainList.stream().toList());
    }
}
