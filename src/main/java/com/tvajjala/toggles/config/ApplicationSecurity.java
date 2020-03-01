package com.tvajjala.toggles.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ThirupathiReddy Vajjala
 */
@ConfigurationProperties(prefix = "application.security")
public class ApplicationSecurity {


    private List<ApplicationUser> users = new ArrayList<>();


    public List<ApplicationUser> getUsers() {
        return users;
    }

    public void setUsers(final List<ApplicationUser> users) {
        this.users = users;
    }
}
