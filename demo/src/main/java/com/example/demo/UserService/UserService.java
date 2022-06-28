package com.example.demo.UserService;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoletoUser(String username,String roleName);
    User getUser(String username);
    List<User> getAllUser();
}
