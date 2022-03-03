package com.codegym.socialbook_be.security_pack.service;


import com.codegym.socialbook_be.user_pack.model.Users;

import java.util.Optional;

public interface IUserService {
    Optional<Users> findByUsername(String name); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Users save(Users users);
    Optional<Users> findById(Long id);
}
