package com.pma.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl implements PasswordEncoder {

    private final BCryptPasswordEncoder passwordEncoder;
    private static final PasswordEncoderImpl _INSTANCE = null;

    private PasswordEncoderImpl() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    public static PasswordEncoderImpl getInstance() {
        if (_INSTANCE == null) {
            return new PasswordEncoderImpl();
        }

        return _INSTANCE;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
