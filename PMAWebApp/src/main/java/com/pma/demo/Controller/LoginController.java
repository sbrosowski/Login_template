package com.pma.demo.Controller;

import com.pma.demo.services.Impl.DTO.LoginDTO;
import com.pma.demo.services.Interfaces.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String Login(@RequestBody String loginCredentials) {
        return userService.doLogin(loginCredentials);
    }

    @GetMapping("/login/forgotPassword")
    public @ResponseBody
    LoginDTO retrievePassword(@RequestParam(value = "email", defaultValue = "") String email) {
        return null;
    }

    @PostMapping(value = "/login/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String register(@RequestBody String registrationInformation) {
        return userService.doRegistration(registrationInformation);
    }
}
