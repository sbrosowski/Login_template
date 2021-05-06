package com.pma.controller;

import com.pma.model.AuthenticationDetails;
import com.pma.model.AuthenticationJwtTokenResponse;
import com.pma.password.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    @PostMapping(value = "/api/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationDetails authenticationDetails) {
        String token;
        JwtUtil util = new JwtUtil();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDetails.getUsername(),
                    authenticationDetails.getPassword()));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Username or Password invalid");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDetails.getUsername());
        String userName = userDetails.getUsername();

        token = util.generateToken(userName);
        return ResponseEntity.ok(new AuthenticationJwtTokenResponse(token));
    }
}
