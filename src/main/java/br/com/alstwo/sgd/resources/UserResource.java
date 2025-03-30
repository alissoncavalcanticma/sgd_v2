package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserResource {

    ResponseEntity<User> findById(Long id);

    ResponseEntity<List<User>> findAll();

    ResponseEntity<User> findByEmail(String email);

}