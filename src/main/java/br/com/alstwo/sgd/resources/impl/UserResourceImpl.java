package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.resources.UserResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class UserResourceImpl implements UserResource {

    @Override
    public ResponseEntity<User> findById(Long Id){
        return null;
    }

    @Override
    public ResponseEntity<List<User>> findAll(){
        return null;
    }

}
