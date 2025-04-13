package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.domain.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface UserResource {

    @GetMapping(value = "/{id}")
    ResponseEntity<UserDTO> findById(Long id);

    @GetMapping
    ResponseEntity<List<UserDTO>> findAll();

/*    ResponseEntity<UserDTO> findByEmail(String email);*/

    @PostMapping
    ResponseEntity<UserDTO> create(User user);

}