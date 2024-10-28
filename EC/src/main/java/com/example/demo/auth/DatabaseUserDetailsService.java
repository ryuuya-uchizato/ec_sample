package com.example.demo.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.common.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DatabaseUserDetailsService implements UserDetailsService {

	private final UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return repository.identifyUser(username).orElseThrow(
				() -> new UsernameNotFoundException(username));

		//		var userInfo = repository.identifyUser(username);
		//
		//		return User.withUsername(userInfo.getEmail())
		//				.password(userInfo.getPassword())
		//				.authorities("USER")
		//				.build();
	}

}
