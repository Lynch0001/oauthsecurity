package com.lynch.oauthsecurity;

import com.lynch.oauthsecurity.domain.AppUser;
import com.lynch.oauthsecurity.domain.Role;
import com.lynch.oauthsecurity.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class OauthsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthsecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(AppUserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_DBADMIN"));

            userService.saveUser(new AppUser(null, "user1", "username1", "password1", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "user2", "username2", "password2", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "user3", "username3", "password3", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "user4", "username4", "password4", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "user5", "username5", "password5", new ArrayList<>()));
        };
    }
}
