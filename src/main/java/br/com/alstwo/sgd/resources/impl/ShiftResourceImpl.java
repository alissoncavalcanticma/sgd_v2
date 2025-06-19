package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.dto.ShiftDTO;
import br.com.alstwo.sgd.resources.ShiftResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ShiftResourceImpl implements ShiftResource {
    @Override
    public ResponseEntity<List<ShiftDTO>> findAll() {
        Integer numb = 2;
        return null;
    }

    @Override
    public ResponseEntity<ShiftDTO> create(ShiftDTO shiftDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ShiftDTO> update(Long id, ShiftDTO shiftDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        return null;
    }
}
