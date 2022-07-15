package com.lynch.oauthsecurity.service;

import com.lynch.oauthsecurity.domain.AppUser;
import com.lynch.oauthsecurity.domain.Role;
import com.lynch.oauthsecurity.repo.AppUserRepo;
import com.lynch.oauthsecurity.repo.RoleRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class AppServiceImpl implements AppUserService{

    Logger LOGGER = Logger.getLogger(String.valueOf(AppServiceImpl.class));

    private final AppUserRepo userRepo;

    private final RoleRepo roleRepo;

    public AppServiceImpl(AppUserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public AppUser saveUser(AppUser user) {
        LOGGER.log(Level.ALL, "Saving user {}", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        LOGGER.log(Level.ALL, "Saving role {}", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        LOGGER.log(Level.ALL, "Adding role {} to user {}", new Object[]{role, username});
        AppUser user = userRepo.findAppUserByUsername(username);
        Role newRole = roleRepo.findByName(role);
        Collection<Role> roles = user.getRoles();
        roles.add(newRole);
        user.setRoles(roles);
    }

    @Override
    public AppUser getUser(String username) {
        LOGGER.log(Level.ALL, "Getting user {}", username);
        return userRepo.findAppUserByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        LOGGER.log(Level.ALL, "Getting all users");
        return userRepo.findAll();
    }

    @Override
    public Page<AppUser> getTwoUsers() {
        LOGGER.log(Level.ALL, "Getting page of users");
        Pageable pageable = PageRequest.of(1,2, Sort.by(Sort.Order.asc("name")));
        return userRepo.findAll(pageable);
    }
}
