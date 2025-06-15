package br.com.alstwo.sgd.services;

import br.com.alstwo.sgd.domain.Shift;

import java.util.List;

public interface ShiftService {

    Shift findById(Long id);
    List<Shift> findAll();
    Shift create(Shift shift);
    Shift update(Shift shift);
    void delete(Long Id);
}
