package com.weshy.springrestapi.services;

import com.weshy.springrestapi.models.User;
import com.weshy.springrestapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user;
    }

    public User createUser(User user) {
        User newUser = userRepository.save(user);
        userRepository.flush();
        return newUser;
    }
}
