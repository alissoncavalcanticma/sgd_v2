package br.com.alstwo.sgd.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DynamicUpdate
@Table(name = "turnos_registro")
@AllArgsConstructor
@Getter
@Setter
public class ShiftRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //Access.READ_ONLY determina o uso desse campo apenas para métodos de Leitura (GET)
    private Long id;

    @Column(name = "usuario_id")
    private Long userId;

    @Column(name = "turno_id")
    private Long shiftId;

    @Column(name = "data")
    private LocalDate date;

    @Column(name = "abertura")
    private LocalDateTime opening;

    @Column(name = "encerramento")
    private LocalDateTime closing;

    private Integer status;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false, updatable = false)
    private Instant created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updated_at;

}
