package com.codeup.codeupspringblog;

import com.codeup.codeupspringblog.services.UserDetailLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private UserDetailLoader usersLoader;

    public SecurityConfiguration(UserDetailLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /* Login Configuration */
                // We want to use our own log in form
                .formLogin()
                // The login form I want to use is served at /login
                .loginPage("/login")
                // After successful login, redirect to /ads
                .defaultSuccessUrl("/ads")
                // Allow all users to visit /login
                .permitAll()
                /* Logout Configuration */
                .and()
                // provide a logout method
                .logout()
                // when a post request is made to /logout, redirect to /login?logout (login page)
                .logoutSuccessUrl("/login?logout")
                .and()
                /* Pages that can be viewed without loggin in */
                // allow requests to the following:
                .authorizeHttpRequests()
                .requestMatchers("/", "/ads") // anyone can visit the home page and the ads index page.
                .permitAll()
                /* Pages that need a logged in user */
                .and()
                // allow requests to the following:
                .authorizeHttpRequests()
                .requestMatchers("/ads/create", "/ads/{id}/edit", "/ads/{id}/delete")
                .authenticated();

        // build the security filter that we just configured above.
        return http.build();
    }
}