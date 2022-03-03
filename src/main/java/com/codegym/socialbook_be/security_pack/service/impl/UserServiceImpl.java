package com.codegym.socialbook_be.security_pack.service.impl;

import com.codegym.socialbook_be.user_pack.model.Users;
import com.codegym.socialbook_be.security_pack.repository.IUserRepository;
import com.codegym.socialbook_be.security_pack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public Optional<Users> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }
}
