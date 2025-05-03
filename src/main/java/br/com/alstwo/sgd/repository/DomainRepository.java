package br.com.alstwo.sgd.repository;

import br.com.alstwo.sgd.domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository  extends JpaRepository<Domain, Long> {
}
