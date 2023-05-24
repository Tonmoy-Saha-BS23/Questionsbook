package com.bs23.Questionsbook.service;

import com.bs23.Questionsbook.entity.User;
import com.bs23.Questionsbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void create(User user){
        userRepository.save(user);
    }
}
