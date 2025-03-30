package br.com.alstwo.sgd.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @Column(unique = true)
    private String user;

    /*
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY);
    private String password;
    */

    @Column(unique = true)
    private String email;
    private String name;
    private String nickname;
}
