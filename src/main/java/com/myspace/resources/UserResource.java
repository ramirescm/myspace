package com.myspace.resources;

import com.myspace.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        var list = new ArrayList<User>();
        list.add(new User("1", "teste", "teste"));
        list.add(new User("2", "vvv", "dddd"));
        return ResponseEntity.ok().body(list);
    }
}
