package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.domain.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserResource {

    ResponseEntity<UserDTO> findById(Long id);

    ResponseEntity<List<UserDTO>> findAll();

    ResponseEntity<UserDTO> findByEmail(String email);

}