package com.tvajjala.toggles.config;

import com.tvajjala.toggles.config.security.ApplicationSecurity;
import com.tvajjala.toggles.config.security.CustomUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security Configuration
 *
 * @author ThirupathiReddy Vajjala
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(ApplicationSecurity.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ApplicationSecurity applicationSecurity;


    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/ui/**")
                .hasAnyAuthority("ADMIN", "DEVELOPER", "QA")
                .and().formLogin()

/*              .and()
                .authorizeRequests()
                .antMatchers("/toggles/**")
                .hasAnyAuthority("ADMIN")
                .and().httpBasic()*/

                .and()
                .logout()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login")
                .logoutUrl("/logout");
    }


   /* @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint("TOGGLE");
    }*/


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService()).passwordEncoder(passwordEncoder());
    }


    @Bean
    public UserDetailsService customUserDetailService() {
        LOGGER.info("Users {} ", applicationSecurity.getUsers());
        return new CustomUserDetailService(applicationSecurity.getUsers());
    }

}
