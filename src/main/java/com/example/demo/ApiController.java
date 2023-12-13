package com.example.demo;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class ApiController {

    List<User> users = new ArrayList<>();

    @PostMapping("user") //curl -X POST localhost:8080/user -H "Content-Type: application/json" -d "{\"username\": \"Nikita\", \"password\": \"2006\", \"age\": 17}"
    public ResponseEntity<?> createUser(@RequestBody User user){
        for(User u : users){
            if (u.getUsername().equals(user.getUsername())){
                return ResponseEntity.status(409).body("This username isn`t available");
            }
        }
        user.setId(users.size());
        users.add(user);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("user/{id}") //curl localhost:8080/user/0
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id){
        for(User u : users){
            if(u.getId() == id){
                return ResponseEntity.ok(u);
            }
        }
        return ResponseEntity.status(404).body("User not found");
    }

    @GetMapping("user") //curl localhost:8080/user
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("user/{id}") //curl -X DELETE localhost:8080/user/0
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        for(User u : users){
            if(u.getId() == id){
                users.remove(u);
                return ResponseEntity.accepted().build();
            }
        }
        return ResponseEntity.status(404).body("User not found");
    }

    @PutMapping("user/{id}") //curl -X PUT localhost:8080/user/0 -H "Content-Type: text/plain" -d Nikita
    public ResponseEntity<?> setUsername(@PathVariable("id") Integer id, @RequestBody String username){
        for(User u : users){
            if(u.getId() == id){
                u.setUsername(username);
                return ResponseEntity.accepted().build();
            }
        }
        return ResponseEntity.status(404).body("User not found");
    }
}