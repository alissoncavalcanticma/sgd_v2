package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.Shift;
import br.com.alstwo.sgd.domain.dto.ShiftDTO;
import br.com.alstwo.sgd.resources.ShiftResource;
import br.com.alstwo.sgd.services.ShiftService;
import br.com.alstwo.sgd.services.exceptions.DataIntegrityViolationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "${api.basePath}${api.domain.shift.path}")
public class ShiftResourceImpl implements ShiftResource {

    private final ShiftService shiftService;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<List<ShiftDTO>> findAll() {
        List<ShiftDTO> listDTO = shiftService.findAll().stream().map(x -> mapper.map(x, ShiftDTO.class)).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @Override
    public ResponseEntity<ShiftDTO> create(@RequestBody ShiftDTO shiftDTO) {
        List<Shift> listShift = shiftService.findAll().stream().filter(x -> ( (x.getDescription().equals(shiftDTO.getDescription())) || (x.getCode().equals(shiftDTO.getCode())) )).toList();
        if(listShift.isEmpty()){
            Shift shift = shiftService.create(mapper.map(shiftDTO, Shift.class));
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(shift.getId()).toUri();
            return ResponseEntity.created(uri).body(mapper.map(shift, ShiftDTO.class));
        }
        throw new DataIntegrityViolationException("Registro semelhante já existe cadastrado");
    }

    @Override
    public ResponseEntity<ShiftDTO> update(@PathVariable Long id, @RequestBody ShiftDTO shiftDTO) {
        Shift shift = shiftService.findById(id);
        if(shift != null){
            List<Shift> shiftList = shiftService.findAll().stream().filter(x -> ( (x.getCode().equals(shiftDTO.getCode())) || (x.getDescription().equals(shiftDTO.getDescription())) ) && !(x.getId().equals(shiftDTO.getId())) ).toList();
            if(shiftList.isEmpty()){
                shiftDTO.setId(id);
                shiftService.update(mapper.map(shiftDTO, Shift.class));
                return ResponseEntity.ok().body(shiftDTO);
            }
            throw new DataIntegrityViolationException("Registro semelhante já existe cadastrado");
        }
        throw new DataIntegrityViolationException("Registro não encontrado.");
    }

    @Override
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Shift shift = shiftService.findById(id);
        if(shift != null){
            shiftService.delete(id);
            return ResponseEntity.ok().body(Map.of("success", true, "deletedId", id));
        }
        throw new DataIntegrityViolationException("Registro não encontrado.");
    }
}
