package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.Shift;
import br.com.alstwo.sgd.repository.ShiftRepository;
import br.com.alstwo.sgd.services.ShiftService;
import br.com.alstwo.sgd.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShiftServiceImpl implements ShiftService {

    private final ShiftRepository shiftRepository;

    @Override
    public Shift findById(Long id) {
        return shiftRepository.findById(id).orElse(null);
    }

    @Override
    public List<Shift> findAll() {
        return List.of();
    }

    @Override
    public Shift create(Shift shift) {
        return null;
    }

    @Override
    public Shift update(Shift shift) {
        return null;
    }

    @Override
    public void delete(Long Id) {

    }
}
