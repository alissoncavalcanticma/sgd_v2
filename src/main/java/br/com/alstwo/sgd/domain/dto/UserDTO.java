package br.com.alstwo.sgd.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;

    /*
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY);
    private String password;
    */

    @Column(unique = true)
    private String email;
    private String nickname;
    private String name;
    private Integer status;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant created_at;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updated_at;

}
