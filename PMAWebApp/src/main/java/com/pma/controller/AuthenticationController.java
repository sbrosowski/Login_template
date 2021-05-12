package com.pma.controller;

import com.pma.password.JwtUtil;
import com.pma.persistence.model.AuthenticationDetails;
import com.pma.persistence.model.AuthenticationJwtTokenResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    @PostMapping(value = "/api/authenticate", consumes = "application/JSON", produces = "application/json")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationDetails authenticationDetails) {
        String token;
        JwtUtil util = new JwtUtil();
        try {
            final Collection<? extends GrantedAuthority> ROLES =
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

            Authentication loginAuthentication;
            loginAuthentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDetails.getUsername(),
                    authenticationDetails.getPassword(), ROLES));

            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(loginAuthentication);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Username or Password invalid");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDetails.getUsername());
        String userName = userDetails.getUsername();

        token = util.generateToken(userName);
        return ResponseEntity.ok(new AuthenticationJwtTokenResponse(token));
    }
}
