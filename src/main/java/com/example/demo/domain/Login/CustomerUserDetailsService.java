package com.example.demo.domain.Login;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.Register.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

	private final UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userMapper.findByUsername(username)
				.map( 
						user -> new CustomUserDetails(
						user.getUsername(),
						user.getPassword(),
						toGrantedAuthorityList(user.getAuthority())
						)
					)
				.orElseThrow(
						() -> new UsernameNotFoundException(
						"Given username is not found.(username ='" + username + "')"
						)
					);
	}

	private List<GrantedAuthority> toGrantedAuthorityList(User.Authority authority) {
		return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));
	}

}
