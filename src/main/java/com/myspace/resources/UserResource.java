package com.myspace.resources;

import com.myspace.dtos.UserDTO;
import com.myspace.entities.User;
import com.myspace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
       var list = userService.findAll()
               .stream()
               .map(e -> new UserDTO(e))
               .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        var user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }
}
