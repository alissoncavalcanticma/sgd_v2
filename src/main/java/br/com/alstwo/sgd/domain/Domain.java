package br.com.alstwo.sgd.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "dominios")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "codigo")
    private Integer code;
    @Column(name = "descricao")
    private String description;
    @Column(name = "grupo")
    private String group;
    @Column(name = "ativo")
    private Boolean active;
    @Column(name = "observacao")
    private String observation;
}
