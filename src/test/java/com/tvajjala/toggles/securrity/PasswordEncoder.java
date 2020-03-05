package com.tvajjala.toggles.securrity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {


    @Test
    public void encryptPassword() {

        Assertions.assertNotNull(new BCryptPasswordEncoder().encode("password"));
    }
}
