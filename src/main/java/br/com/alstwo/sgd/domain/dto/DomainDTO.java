package br.com.alstwo.sgd.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DomainDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    private Long id;
    @Column(name = "codigo")
    private Integer code;
    @Column(name = "descricao")
    private String description;
    @Column(name = "grupo")
    private String group;
    @Column(name = "ativo")
    private Integer active;
    @Column(name = "observacao")
    private String observation;
}
