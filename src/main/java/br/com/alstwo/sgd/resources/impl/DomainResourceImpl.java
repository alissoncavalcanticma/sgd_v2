package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.Domain;
import br.com.alstwo.sgd.resources.DomainResource;
import br.com.alstwo.sgd.services.DomainService;
import br.com.alstwo.sgd.services.exceptions.DataIntegrityViolationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping(value = "${api.basePath}${api.domain.domain.path}")
@RestController
public class DomainResourceImpl implements DomainResource {

    private final DomainService domainService;


    @Override
    /* Anotações do Swagger */
    @Operation(summary = "Cadastro de domínios", description = "Cadastro de domínios", tags = "Domain")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Domínio criado"),
            @ApiResponse(responseCode = "400", description = "Erro de criação de domínio")
    }
    )
    public ResponseEntity<Domain> create(@RequestBody Domain domain){
        Domain dm = domainService.create(domain);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(domain.getId()).toUri();
        return ResponseEntity.created(uri).body(domain);
    }


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


    @Override
    /* Anotações do Swagger */
    @Operation(summary = "Alteração de domínio", description = "Alteração de domínio", tags = "Domain")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conforma alteração de domínio"),
            @ApiResponse(responseCode = "400", description = "Erro ao alterar domínio")
    }
    )
    /* Anotações do Swagger */
    public ResponseEntity<Domain> update(@PathVariable Long id, @RequestBody Domain domain){
        Domain dm = domainService.findById(id);
        if(dm != null){
            domain.setId(id);
            domainService.update(domain);
            return ResponseEntity.ok().body(domain);
        }else{
            throw new DataIntegrityViolationException("Domínio não encontrado.");
        }
    }

    @Override
    /* Anotações do Swagger  */
    @Operation(summary = "Deleção de domínio", description = "Deleção de cadastro de domínio", tags = "Domain")  //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleção realizada com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    type = "object",
                                    example = "{\"success\": true, \"deletedId\": 1}"
                            )
                    )),
            @ApiResponse(responseCode = "400", description = "Tentativa de deleção falhou.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    type = "object",
                                    example = "{\"success\": false, \"deletedId\": null}"
                            )

                    ))
    })
    /* Anotações do Swagger  */
    public ResponseEntity<Object> delete(@PathVariable Long id){
        domainService.delete(id);
        return ResponseEntity.ok().body(Map.of("success", true, "deletedId", id));
    }
}
