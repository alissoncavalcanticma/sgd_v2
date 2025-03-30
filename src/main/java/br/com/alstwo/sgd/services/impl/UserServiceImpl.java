package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.repository.UserRepository;
import br.com.alstwo.sgd.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email){
        Optional<User> userOptional= userRepository.findBy();
        return null;
    }
}
