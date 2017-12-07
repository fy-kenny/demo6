package com.example.demo6.service;

import com.example.demo6.model.StudentWork;
import com.example.demo6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo6.model.User;

import java.util.List;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/9/15 19:49
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> query() {
        return userRepository.findAll();
    }
}
