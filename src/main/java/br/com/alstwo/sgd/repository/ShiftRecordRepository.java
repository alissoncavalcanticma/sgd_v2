package br.com.alstwo.sgd.repository;

import br.com.alstwo.sgd.domain.ShiftRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ShiftRecordRepository extends JpaRepository<ShiftRecord, Long>{

    @Query(nativeQuery = true, value = """
            SELECT *
            FROM turnos_registro tr
            WHERE (:id IS NULL OR tr.id = :id)
            AND (:userId IS NULL OR tr.usuario_id = :userId)
            AND (:shiftId IS NULL OR tr.turno_id = :shiftId)
            AND (
                    (:startDate IS NULL OR tr.data >= :startDate)
                    AND (:endDate IS NULL OR tr.data <= :endDate)
                )
            AND (:status IS NULL OR tr.status = :status)
            """)
    List<ShiftRecord> findByAllFilters(
            Long id,
            Long userId,
            Long shiftId,
            LocalDate startDate,
            LocalDate endDate,
            Integer status);
}
