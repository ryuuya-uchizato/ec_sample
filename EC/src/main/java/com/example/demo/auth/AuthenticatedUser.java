package com.example.demo.auth;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.common.Option;

import lombok.Data;

@Data
public class AuthenticatedUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	private long member_code;

	private String username;

	private String last_name;

	private String frist_name;

	private String last_name_kana;

	private String first_name_kana;

	private String email;

	private String password;

	private String post_code;

	private String address;

	private String tel_number;

	private String gender_code;

	private Date birthday;

	private boolean expired;

	private boolean locked;

	private List<Option> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
				.map((o) -> new SimpleGrantedAuthority(o.getName()))
				.collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return !expired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !expired;
	}

	@Override
	public boolean isEnabled() {
		return !locked;
	}

}
