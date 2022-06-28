package com.example.demo.controllers;

import com.example.demo.UserService.UserService;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        System.out.println(userService.getAllUser());
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity(userService.saveRole(role), HttpStatus.CREATED);
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoletoUser(@RequestBody RoletoUser roletoUser) {
        userService.addRoletoUser(roletoUser.getUsername(),roletoUser.getRolename());
        return new ResponseEntity(HttpStatus.OK);
    }

}

@Data
class RoletoUser {
    private String username;
    private String rolename;
}