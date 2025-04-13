package br.com.alstwo.sgd.repository;

import br.com.alstwo.sgd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    /*== Aux method ==*/
    Optional<User> findByEmail(String email);
}
