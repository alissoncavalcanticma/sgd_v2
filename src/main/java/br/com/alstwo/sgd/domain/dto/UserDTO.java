package br.com.alstwo.sgd.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    @Schema(type = "integer", format = "int64", example = "9")
    private Long id;

    private String login;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Access.WRITE_ONLY determina o uso desse campo apenas para métodos de escrita (POST e PUT)
    private String password;


    private String email;
    private String nickname;
    private String name;

    @Schema(type = "integer", format = "int64", example = "1")
    private Integer status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    private Instant created_at;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    private Instant updated_at;

}
