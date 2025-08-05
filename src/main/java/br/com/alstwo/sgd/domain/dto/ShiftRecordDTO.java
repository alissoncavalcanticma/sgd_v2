package br.com.alstwo.sgd.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ShiftRecordDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    @Schema(type = "integer", format = "int64", example = "2")
    private Long id;

    private Long userId;

    private Long shiftId;

    private LocalDate date;

    private LocalDateTime opening;

    private LocalDateTime closing;

    @Schema(type = "integer", format = "int64", example = "3")
    private Integer status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant created_at;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant updated_at;

}