package com.example.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

/**
 * Spring Securityの設定を行うクラス。 1,ConfigurationとEnableWebSecurityアノテーションを付ける
 * 2,WebSecurityConfigurerAdapterを継承する の2つが必要。
 * 
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.mvcMatchers("/login/**").permitAll()
		.mvcMatchers("/users/**").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
	    .loginPage("/login").permitAll()
        .defaultSuccessUrl("/announcements", true);

	}

	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
	 
}

