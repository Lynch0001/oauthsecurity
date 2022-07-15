package com.lynch.oauthsecurity.service;

import com.lynch.oauthsecurity.domain.AppUser;
import com.lynch.oauthsecurity.domain.Role;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AppUserService {

    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String role);

    AppUser getUser(String username);

    List<AppUser> getUsers();

    Page<AppUser> getTwoUsers();
}
