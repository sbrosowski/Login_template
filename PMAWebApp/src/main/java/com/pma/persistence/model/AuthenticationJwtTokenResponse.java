package com.pma.persistence.model;

public class AuthenticationJwtTokenResponse {


    private final String jwtToken;

    public AuthenticationJwtTokenResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

}
