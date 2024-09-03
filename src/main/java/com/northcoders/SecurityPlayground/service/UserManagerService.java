package com.northcoders.SecurityPlayground.service;

import com.northcoders.SecurityPlayground.data.User;

import java.util.List;

public interface UserManagerService {
    List<User> getAllUsers();
    User insertUser(User user);
    User getUserById(Long id);
//    User updateUserById(User userFound, User userUpdated);
    String deleteUserById(Long id);

}
