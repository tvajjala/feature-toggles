package com.tvajjala.toggles.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ThirupathiReddy Vajjala
 */
public class CustomPasswordEncoder implements PasswordEncoder {

    private static final PasswordEncoder INSTANCE = new CustomPasswordEncoder();

    public String encode(final CharSequence rawPassword) {
        return rawPassword.toString();
    }

    public boolean matches(final CharSequence rawPassword, final String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

    private CustomPasswordEncoder() {
    }
}
