package com.KDGroup.Knowledge_Deck.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(dataSource);
        return userDetailsManager;
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
        jdbcDaoImpl.setDataSource(dataSource);

        jdbcDaoImpl.setUsersByUsernameQuery(
                "SELECT email, password,phone_number, 1 as enabled FROM student_login WHERE email = ?"
                        + " UNION SELECT email, password, null AS phone_number, 1 as enabled FROM school_login WHERE email = ?"
                        + " UNION SELECT email, password, phone_number, 1 as enabled FROM Partner_associate_login WHERE email = ?");

        jdbcDaoImpl.setAuthoritiesByUsernameQuery(
                "SELECT email, 'ROLE_STUDENT' as role FROM student_login WHERE email = ?"
                        + " UNION SELECT email, 'ROLE_SCHOOL' as role FROM school_login WHERE email = ?"
                        + " UNION SELECT email, 'ROLE_PARTNER' as role FROM Partner_associate_login WHERE email = ?");

        return jdbcDaoImpl;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
