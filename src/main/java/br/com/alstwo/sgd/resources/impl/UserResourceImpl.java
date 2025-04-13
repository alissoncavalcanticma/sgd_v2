package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.domain.dto.UserDTO;
import br.com.alstwo.sgd.resources.UserResource;
import br.com.alstwo.sgd.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    /* Anotações do Swagger */
    @Operation(summary = "Consulta pelo identificador do usuário", description = "Consulta o usuário pelo ID", tags = "Users") //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o usuário."),
            @ApiResponse(responseCode = "400", description = "usuário não encontrado.")
    })
    /* Anotações do Swagger */
    //@Tag(name = "Users") //Annotation of Swagger
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(mapper.map(user, UserDTO.class));
    }

    @Override
    /* Anotações do Swagger */
    @Operation(summary = "Consulta de usuários", description = "Consulta de lista de usuários", tags = "Users") //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna lista de usuários."),
            @ApiResponse(responseCode = "400", description = "Erro na consulta.")
    })
    /* Anotações do Swagger */
    //@Tag(name = "Users") //Annotation of Swagger
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<UserDTO> userDTO = users.stream().map(x -> mapper.map(x, UserDTO.class)).toList();
        return ResponseEntity.ok().body(userDTO);
    }
/*
    @Override
    @GetMapping("/findByEmail")
    @Tag(name = "Users") //Annotation of Swagger
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {
        UserDTO user = mapper.map(userService.findByEmail(email), UserDTO.class);
        return ResponseEntity.ok().body(user);
    }*/
}
