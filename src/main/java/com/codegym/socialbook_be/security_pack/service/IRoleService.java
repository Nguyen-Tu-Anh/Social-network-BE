package com.codegym.socialbook_be.security_pack.service;



import com.codegym.socialbook_be.security_pack.model.Role;
import com.codegym.socialbook_be.security_pack.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
