package br.com.alstwo.sgd.services.impl;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.repository.UserRepository;
import br.com.alstwo.sgd.services.UserService;
import br.com.alstwo.sgd.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor //Define construtor incluindo propriedades final (Dependecy Injection)
//@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Registro " + id + " não encontrado!"));
        userRepository.deleteById(id);
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Registro " + id + " não encontrado!"));
//        userRepository.delete(user);
    }

    /*== Aux method ==*/
    @Override
    public User findByEmail(String email){
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.orElse(null);
    }

}
