package com.lynch.oauthsecurity.repo;


import com.lynch.oauthsecurity.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByUsername(String username);
}
