package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.ShiftRecord;
import br.com.alstwo.sgd.domain.dto.ShiftRecordDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

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

    ResponseEntity<List<ShiftRecordDTO>> findByAllFilters (Long id, Long userId, Long shiftId, LocalDate startDate, LocalDate endDate, Integer status, Integer code);

    ResponseEntity<ShiftRecordDTO> create(ShiftRecord shiftRecord, Integer code);

    ResponseEntity<ShiftRecordDTO> update(Long id, ShiftRecord shiftRecord);

    ResponseEntity<Object> delete(Long id);

}
