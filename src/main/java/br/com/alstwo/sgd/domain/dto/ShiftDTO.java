package br.com.alstwo.sgd.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalTime;

public class ShiftDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    @Schema(type = "integer", format = "int64", example = "27")
    private Long id;

    @Column(name = "codigo")
    @Schema(type = "integer", format = "int64", example = "2")
    private Integer code;

    @Column(name = "inicio")
    private LocalTime start;

    @Column(name = "fim")
    private LocalTime end;

    @Column(name = "descricao")
    private String description;

    @Schema(type = "integer", format = "int64", example = "1")
    private int status;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    private Instant created_at;

    @UpdateTimestamp
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    private Instant updated_at;
}
