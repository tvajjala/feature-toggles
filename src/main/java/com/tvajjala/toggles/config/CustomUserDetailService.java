package com.tvajjala.toggles.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author ThirupathiReddy Vajjala
 */
public class CustomUserDetailService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);

    private final Map<String, ApplicationUser> appUsers = new HashMap<>();

    public CustomUserDetailService(final List<ApplicationUser> users) {
        appUsers.putAll(users.stream().collect(Collectors.toMap(user -> user.getUsername(), user -> user)));
        LOGGER.warn("Users {} ", users);
    }

    @Override
    public ApplicationUser loadUserByUsername(final String username) throws UsernameNotFoundException {

        if (!appUsers.containsKey(username)) {
            LOGGER.warn("User {} not found", username);
            throw new UsernameNotFoundException("User " + username + " Not found");
        }
        LOGGER.info("User with username {} found ", username);
        return appUsers.get(username);
    }
}
