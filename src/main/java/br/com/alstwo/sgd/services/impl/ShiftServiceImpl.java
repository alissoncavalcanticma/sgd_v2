package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.Shift;
import br.com.alstwo.sgd.repository.ShiftRepository;
import br.com.alstwo.sgd.services.ShiftService;
import br.com.alstwo.sgd.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
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
    public Shift updateParcial(Shift shift) {
        Shift entity = shiftRepository.findById(shift.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Turno não encontrado"));

        // Atualiza apenas se o campo estiver presente no DTO
        if (shift.getCode() != null) entity.setCode(shift.getCode());
        if (shift.getDescription() != null) entity.setDescription(shift.getDescription());
        if (shift.getStart() != null) entity.setStart(shift.getStart());
        if (shift.getEnd() != null) entity.setEnd(shift.getEnd());
        if (shift.getStatus() != null) entity.setStatus(shift.getStatus());

        return shiftRepository.save(entity); // agora o Hibernate reconhece quais campos mudaram
    }

    @Override
    public void delete(Long id) {
        shiftRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Turno não encontrado."));
        shiftRepository.deleteById(id);
    }
}
