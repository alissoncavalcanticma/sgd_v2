package br.com.alstwo.sgd.repository;

import br.com.alstwo.sgd.domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DomainRepository  extends JpaRepository<Domain, Long> {

    @Query(nativeQuery = true, value = """
            SELECT * 
            FROM dominios dm
            WHERE (:id IS NULL OR dm.id = :id)
            AND (:ativo IS NULL OR dm.ativo = :ativo)
            AND (:grupo IS NULL OR dm.grupo LIKE :grupo);
            """)
    Optional<List<Domain>> findByAllFilters(@Param("id") Long id, @Param("ativo") Integer active, @Param("grupo") String group);
}
