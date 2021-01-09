package com.pma.controller;

import com.pma.DTO.LoginDTO;
import com.pma.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String Login(@RequestBody String loginCredentials) {
        return userService.doLogin(loginCredentials);
    }

    @GetMapping("/login/forgotPassword")
    public @ResponseBody
    LoginDTO retrievePassword(@RequestParam(value = "email", defaultValue = "") String email) {
        return null;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String register(@RequestBody String registrationInformation) {
        return userService.doRegistration(registrationInformation);
    }
}
