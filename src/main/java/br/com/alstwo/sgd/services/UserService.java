package br.com.alstwo.sgd.services;

import br.com.alstwo.sgd.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
   /* User findByEmail(String email);*/
    User create(User user);
    User update(User user);
    void delete(Long id);
}
