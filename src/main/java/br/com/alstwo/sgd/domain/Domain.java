package br.com.alstwo.sgd.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "dominios")
public class Domain {

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
