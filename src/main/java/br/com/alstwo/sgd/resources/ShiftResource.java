package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.dto.ShiftDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ShiftResource {

    @GetMapping
    /* Anotações do Swagger */
    @Operation(summary = "Consulta de turnos", description = "Consulta lista de turnos", tags = "Shift") //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de consulta com erro.")
    })
    /* Anotações do Swagger */
    ResponseEntity<List<ShiftDTO>> findAll();

    @PostMapping
    /* Anotações do Swagger */
    @Operation(summary = "Cadastro de turno", description = "Cadastro de novo turno", tags = "Shift") //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro realizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de cadastro apresentou erro.")
    })
    /* Anotações do Swagger */
    ResponseEntity<ShiftDTO> create(ShiftDTO shiftDTO);

    @PatchMapping(value = "/{id}")
    /* Anotações do Swagger */
    @Operation(summary = "Alteração de turno", description = "Alteração de cadastro de turno", tags = "Shift") //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alteração realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de atualização apresentou erro.")
    })
    /* Anotações do Swagger */
    ResponseEntity<ShiftDTO> update(Long id, ShiftDTO shiftDTO);

    @DeleteMapping(value = "/{id}")
    /* Anotações do Swagger */
    @Operation(summary = "Deleção de turno", description = "Deleção de cadastro de turno", tags = "Shift") //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleção realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de Deleção apresentou erro.")
    })
    /* Anotações do Swagger */
    ResponseEntity<Object> delete(Long id);
}
