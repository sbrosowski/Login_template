package com.pma.filters;

import com.pma.password.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFilterChain extends OncePerRequestFilter {


    private static final String AuthorizationHeader = "Authorization";
    private static final String AuthorizationValuePrefix = "Bearer ";

    private final UserDetailsService userDetailsService;

    public AuthenticationFilterChain(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        JwtUtil jwtUtil = new JwtUtil();

        String jwtUsername = null;
        String jwt = null;

        String authorizationHeader = request.getHeader(AuthorizationHeader);

        if (authorizationHeader != null && authorizationHeader.startsWith(AuthorizationValuePrefix)) {
            jwt = StringUtils.substringAfter(authorizationHeader, AuthorizationValuePrefix);
            jwtUsername = jwtUtil.extractUserName(jwt);
        }

        if (jwtUsername != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(jwtUsername);

            if (userDetails.getUsername() != null && jwtUtil.validateToken(jwt, userDetails.getUsername())) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
