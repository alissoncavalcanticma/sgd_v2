package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.ShiftRecord;
import br.com.alstwo.sgd.repository.ShiftRecordRepository;
import br.com.alstwo.sgd.services.ShiftRecordService;
import br.com.alstwo.sgd.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftRecordServiceImpl implements ShiftRecordService {

    private final ShiftRecordRepository shiftRecordRepository;

    @Override
    public ShiftRecord findById(Long id) {
        return shiftRecordRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Registro de turno não encontrado"));
    }

    @Override
    public List<ShiftRecord> findByAllFilters(Long id, Long userId, Long shiftId, LocalDateTime opening, LocalDateTime closing, Integer status) {
        return List.of();
    }

    @Override
    public ShiftRecord create(ShiftRecord shiftRecord) {
        return null;
    }

    @Override
    public ShiftRecord update(ShiftRecord shiftRecord) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
