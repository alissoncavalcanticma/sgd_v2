package br.com.alstwo.sgd.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;
import java.time.LocalTime;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShiftDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    @Schema(type = "integer", format = "int64", example = "27")
    private Long id;

    @Schema(type = "integer", format = "int64", example = "2")
    private Integer code;

    private LocalTime start;

    private LocalTime end;

    private String description;

    @Schema(type = "integer", format = "int64", example = "1")
    private Integer status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    private Instant created_at;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    private Instant updated_at;
}
