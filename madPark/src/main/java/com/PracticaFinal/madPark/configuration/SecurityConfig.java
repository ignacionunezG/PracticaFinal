package com.PracticaFinal.madPark.configuration;

import java.util.HashMap;
import java.util.Map;

import com.PracticaFinal.madPark.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private CustomerService customerService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder defaultEncoder = NoOpPasswordEncoder.getInstance();
        
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("bcrypt", new BCryptPasswordEncoder());

        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);
        passwordEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);
        return passwordEncoder;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
                .antMatchers("/api/v1/documents", "/api/v1/documents/**").permitAll() //las url que no necesitan auth (login y esas)
                .anyRequest().authenticated()
            .and()
            .logout(logout -> logout
                .logoutUrl("/api/v1/logout")
                .logoutSuccessUrl("/api/v1/customers")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
            )
            .httpBasic()
            .and()
            .cors().and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customerService).passwordEncoder(passwordEncoder());
    }

}
