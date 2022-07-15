package com.lynch.oauthsecurity.repo;

import com.lynch.oauthsecurity.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String username);
}
