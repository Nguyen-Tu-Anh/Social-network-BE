package com.codegym.socialbook_be.security_pack.service.impl;


import com.codegym.socialbook_be.security_pack.model.Role;
import com.codegym.socialbook_be.security_pack.model.RoleName;
import com.codegym.socialbook_be.security_pack.repository.IRoleRepository;
import com.codegym.socialbook_be.security_pack.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
