package com.pma.demo.Login;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String Login(@RequestBody String loginCredentials) {
        Gson request = new Gson();
        request.fromJson(loginCredentials, LoginDTO.class);

        //Service aufrufen

        LoginDTO loginResponse = new LoginDTO();
        loginResponse.setResultMessage("Geht nicht");
        Gson gsonResult = new Gson();
        return gsonResult.toJson(loginResponse);
    }

    @GetMapping("/login/forgotPassword")
    public @ResponseBody
    LoginDTO retrievePassword(@RequestParam(value = "email", defaultValue = "") String email) {
        return null;
    }

    @GetMapping("/login/register")
    public @ResponseBody
    LoginDTO register(@RequestParam(value = "user", defaultValue = "") String user,
                      @RequestParam(value = "password", defaultValue = "") String password,
                      @RequestParam(value = "email", defaultValue = "") String email) {
        return null;
    }
}
