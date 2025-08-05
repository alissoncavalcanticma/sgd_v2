package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.ShiftRecord;
import br.com.alstwo.sgd.services.ShiftRecordService;

import java.time.LocalDateTime;
import java.util.List;

public class ShiftRecordServiceImpl implements ShiftRecordService {

    @Override
    public ShiftRecord findById(Long id) {
        return null;
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
