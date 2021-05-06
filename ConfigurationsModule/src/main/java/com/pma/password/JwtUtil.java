package com.pma.password;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtUtil {
    private final String secret = "TODO_HASH_HINTERLEGEN";

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String repositoryUsername) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, repositoryUsername);
    }

    private String createToken(Map<String, Object> claims, String repositoryUsername) {
        long timeExpirationInHours = System.currentTimeMillis() + (1000 * 60 * 60);

        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(new Date(timeExpirationInHours)).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, String repositoryUsername) {
        final String username = extractUserName(token);
        return repositoryUsername.equals(username) && !this.isTokenExpired(token);
    }

}
