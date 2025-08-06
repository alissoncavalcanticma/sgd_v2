package br.com.alstwo.sgd.services;

import br.com.alstwo.sgd.domain.ShiftRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ShiftRecordService {

    ShiftRecord findById(Long id);
    List<ShiftRecord> findByAllFilters (Long id, Long userId, Long shiftId, LocalDate startDate, LocalDate endDate, Integer status);
    ShiftRecord create(ShiftRecord shiftRecord);
    ShiftRecord update(ShiftRecord shiftRecord);
    void delete(Long id);
}
