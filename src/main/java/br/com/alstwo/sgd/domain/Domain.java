package br.com.alstwo.sgd.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "dominios")
public class Domain {

    @Id
    private Long id;
    private Integer code;
    private String description;
    private String group;
    private Boolean active;
    private String observation;
}
