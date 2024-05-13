package com.example.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface UserService {
    User getUser(int id);
    @Service
    @RequiredArgsConstructor
    public class UserServiceImpl implements UserService {

        private final UserRepository userRepository;

        @Override
        public User getUser(int id) {
            return (User) userRepository.findById(id).orElse(null);
        }
    }

}

