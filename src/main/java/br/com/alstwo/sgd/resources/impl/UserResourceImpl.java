package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.resources.UserResource;
import br.com.alstwo.sgd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.basePath}${api.domain.users.path}")
public class UserResourceImpl implements UserResource {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(users);
    }

    @Override
    @GetMapping("/findByEmail")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }
}
