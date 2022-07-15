package com.lynch.oauthsecurity.controller;

import com.lynch.oauthsecurity.domain.AppUser;
import com.lynch.oauthsecurity.service.AppServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class AppUserController {

    Logger LOGGER = Logger.getLogger(String.valueOf(AppServiceImpl.class));

    private final AppServiceImpl appService;

    public AppUserController(AppServiceImpl appService) {
        this.appService = appService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUsers(){
        LOGGER.log(Level.ALL, "Getting users");
        return ResponseEntity.ok(appService.getUsers());
    }
}


