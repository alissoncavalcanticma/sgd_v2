package br.com.alstwo.sgd.resources.impl;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.domain.dto.UserDTO;
import br.com.alstwo.sgd.resources.UserResource;
import br.com.alstwo.sgd.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "${api.basePath}${api.domain.users.path}")
public class UserResourceImpl implements UserResource {

    private final UserService userService;

    private final ModelMapper mapper;

    @Override
    /* Anotações do Swagger */
    @Operation(summary = "Consulta pelo identificador do usuário", description = "Consulta o usuário pelo ID", tags = "Users") //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o usuário."),
            @ApiResponse(responseCode = "204", description = "Usuário não encontrado. Retorno vazio.", content = @Content())
    })
    /* Anotações do Swagger */
    //@Tag(name = "Users") //Annotation of Swagger
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        User user = userService.findById(id);
        if(user == null) {
            return ResponseEntity.noContent().build();
        }
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

    @Override
    /* Anotações do Swagger */
    @Operation(summary = "Cadastro de usuário", description = "Cadastro de novo usuário", tags = "Users") //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro de usuário com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de cadastro de usuário com erro.")
    })
    /* Anotações do Swagger */
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        User user = userService.create(mapper.map(userDTO, User.class));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(mapper.map(user, UserDTO.class));
    }



    @Override
    /* Anotações do Swagger */
    @Operation(summary = "Alteração de cadastro de usuário", description = "Alteração de cadastro de usuário", tags = "Users") //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alteração realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Tentativa de alteração não realizada.")
    })
    /* Anotações do Swagger */
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDTO){
        userDTO.setId(id);
        User user = userService.update(mapper.map(userDTO, User.class));
        return ResponseEntity.ok().body(mapper.map(user, UserDTO.class));
    }


    @Override
    /* Anotações do Swagger  */
    @Operation(summary = "Deleção de usuário", description = "Deleção de cadastro de usuário", tags = "Users")  //Annotation of swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleção realizada com sucesso.",
                    content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                                type = "object",
                                                example = "{\"success\": true, \"deletedUserID\": 1}"
                    )
            )),
            @ApiResponse(responseCode = "400", description = "Tentativa de deleção não realizada.",
                    content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            type = "object",
                                            example = "{\"success\": false, \"deletedUserID\": null}"
                                    )

            ))
    })
    /* Anotações do Swagger  */
    public ResponseEntity<Object> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok().body(Map.of("success", true, "deletedUserID", id));
    }
}
