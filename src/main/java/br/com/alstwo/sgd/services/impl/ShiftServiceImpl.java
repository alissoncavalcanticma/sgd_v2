package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.Shift;
import br.com.alstwo.sgd.repository.ShiftRepository;
import br.com.alstwo.sgd.services.ShiftService;
import br.com.alstwo.sgd.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftServiceImpl implements ShiftService {

    private final ShiftRepository shiftRepository;

    @Override
    public Shift findById(Long id) {
        return shiftRepository.findById(id).orElse(null);
    }

    @Override
    public List<Shift> findAll() {
        return shiftRepository.findAll();
    }

    @Override
    public Shift create(Shift shift) {
        return shiftRepository.save(shift);
    }

    @Override
    public Shift update(Shift shift) {
        shiftRepository.findById(shift.getId()).orElseThrow(() -> new ObjectNotFoundException("Turno não encontrado."));
        return shiftRepository.save(shift);
    }

    @Override
    public void delete(Long id) {
        shiftRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Turno não encontrado."));
        shiftRepository.deleteById(id);
    }
}
