package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.domain.dto.UserDTO;
import br.com.alstwo.sgd.resources.UserResource;
import br.com.alstwo.sgd.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.basePath}${api.domain.users.path}")
public class UserResourceImpl implements UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(mapper.map(User.class, UserDTO.class));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<UserDTO> userDTO = users.stream().map(x -> mapper.map(x, UserDTO.class)).toList();
        return ResponseEntity.ok().body(userDTO);
    }

    @Override
    @GetMapping("/findByEmail")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {
        UserDTO user = mapper.map(userService.findByEmail(email), UserDTO.class);
        return ResponseEntity.ok().body(user);
    }
}
