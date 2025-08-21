package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.ShiftRecord;
import br.com.alstwo.sgd.domain.dto.ShiftRecordDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

public interface ShiftRecordResource {

    @GetMapping(value = "/{id}")
    /* Anotações do Swagger */
    @Operation(summary = "Consulta de registro de turno", description = "Consulta de registro de turno por id", tags = "ShiftRecord")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de consulta com erro.")
    })
    /* Anotações do Swagger */
    ResponseEntity<ShiftRecordDTO> findById(Long id);


    @GetMapping
    /*Anotações do Swagger*/
    @Operation(summary = "Consulta de registro de turno", description = "Consulta de registro de turnos com vários filtros", tags = "ShiftRecord")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de consulta com erro.")
    })
    /*Anotações do Swagger*/
    ResponseEntity<List<ShiftRecordDTO>> findByAllFilters (@RequestParam(required = false) Long id, @RequestParam(required = false) Long userId, @RequestParam(required = false) Long shiftId, @RequestParam(required = false) LocalDate startDate, @RequestParam(required = false) LocalDate endDate, @RequestParam(required = false) Integer status, @RequestParam(required = false) Integer code);



    @PostMapping
    @Operation(summary = "Criação de registro de turno", description = "Criação de registro de turno.", tags = "ShiftRecord")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Criação realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Tentativa de criação apresentou erro.")
    })
    ResponseEntity<ShiftRecordDTO> create(@RequestBody ShiftRecord shiftRecord, @RequestBody(required = false) Integer code);
    /*Anotações do Swagger*/


    @PutMapping(value = "/{id}")
    /*Anotações do Swagger*/
    @Operation(summary = "Alteração de registro de turno.", description = "Alteração de registro de turno.", tags = "ShiftRecord")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Alteração realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de alteração apresentou erro.")
    })
    /*Anotações do Swagger*/
    ResponseEntity<ShiftRecordDTO> update(@PathVariable Long id, @RequestBody ShiftRecord shiftRecord);

    @DeleteMapping(value = "/{id}")
    /*Anotações do Swagger*/
    @Operation(summary = "Deleção de registro de turno", description = "Deleção de registro de turno", tags = "ShiftRecord")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleção realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de deleção com erro.")
    })
    /*Anotações do Swagger*/
    ResponseEntity<Object> delete(@PathVariable Long id);

}
