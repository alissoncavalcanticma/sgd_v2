package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.ShiftRecord;
import br.com.alstwo.sgd.repository.ShiftRecordRepository;
import br.com.alstwo.sgd.services.ShiftRecordService;
import br.com.alstwo.sgd.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<ShiftRecord> findByAllFilters(Long id, Long userId, Long shiftId, LocalDate startDate, LocalDate endDate, Integer status, Integer code) {
        return shiftRecordRepository.findByAllFilters(id, userId, shiftId, startDate, endDate, status, code);
    }

    @Override
    public ShiftRecord create(ShiftRecord shiftRecord, Integer shiftCode) {
        List<ShiftRecord> shiftRecordList = shiftRecordRepository.findByAllFilters(null, null, null, shiftRecord.getDate(), shiftRecord.getDate(), null, shiftCode);
        if(!shiftRecordList.isEmpty()){
            return null;
        }
        return shiftRecordRepository.save(shiftRecord);
    }

    @Override
    public ShiftRecord update(ShiftRecord shiftRecord) {
        ShiftRecord shiftRec = shiftRecordRepository.findById(shiftRecord.getId()).orElseThrow(() -> new ObjectNotFoundException("Registro de turno não encontrado."));
        return shiftRecordRepository.save(shiftRecord);
    }

    @Override
    public void delete(Long id) {
        shiftRecordRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Turno não encontrado."));
        shiftRecordRepository.deleteById(id);
    }
}
