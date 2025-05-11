package br.com.alstwo.sgd.repository;

import br.com.alstwo.sgd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    /*== Aux method ==*/
    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true, value = """
            SELECT *
            FROM usuarios u
            WHERE (:id IS NULL OR u.id = :id)
            AND (:email IS NULL OR u.email LIKE '%:email%')
            AND (:status IS NULL OR u.status = :status);
            """ )
    Optional<List<User>> findByAllFilters(@Param("id") Integer id, @Param("email") String email, @Param("status") Integer status);
}
