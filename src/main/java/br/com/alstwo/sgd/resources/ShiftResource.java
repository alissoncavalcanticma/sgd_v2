package br.com.alstwo.sgd.resources;

import br.com.alstwo.sgd.domain.dto.ShiftDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface ShiftResource {

    @GetMapping
    ResponseEntity<List<ShiftDTO>> findAll();

    @PostMapping
    ResponseEntity<ShiftDTO> create(ShiftDTO shiftDTO);

    @PutMapping(value = "/{id}")
    ResponseEntity<ShiftDTO> update(Long id, ShiftDTO shiftDTO);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Object> delete(Long id);
}
