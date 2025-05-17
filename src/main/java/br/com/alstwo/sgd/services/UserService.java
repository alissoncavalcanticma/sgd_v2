package br.com.alstwo.sgd.services;

import br.com.alstwo.sgd.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User create(User user);
    User update(User user);
    void delete(Long id);
    /*== Aux method ==*/
    User findByEmail(String email);
    List<User> findByAllFilters(Long id, String email, Integer status);
}
