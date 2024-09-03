package com.northcoders.SecurityPlayground.service;

import com.northcoders.SecurityPlayground.data.User;
import com.northcoders.SecurityPlayground.exception.UserNotFoundException;
import com.northcoders.SecurityPlayground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserManagerServiceImpl implements UserManagerService{

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id).get();
        } else {
            throw new UserNotFoundException(String.format("The user with id '%s' cannot be found.", id));
        }
    }

    @Override
    public String deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return String.format("The user with id '%s' has been deleted successfully.", id);
        } else {
            throw new UserNotFoundException(String.format("The user with id '%s' cannot be found.", id));
        }
    }
}
