package br.com.alstwo.sgd.repository;

import br.com.alstwo.sgd.domain.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ShiftRespository extends JpaRepository<Shift, Long>{

}
