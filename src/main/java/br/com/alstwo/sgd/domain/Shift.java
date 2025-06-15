package br.com.alstwo.sgd.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "turnos")
@AllArgsConstructor
@Getter
@Setter
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private Integer code;

    @Column(name = "inicio")
    private LocalTime start;

    @Column(name = "fim")
    private LocalTime end;

    @Column(name = "descricao")
    private String description;

    private int status;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false, updatable = false)
    private Instant created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updated_at;

}
