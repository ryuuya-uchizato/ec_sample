package com.example.demo.common;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.auth.AuthenticatedUser;

@Mapper
public interface UserRepository {

	public Optional<AuthenticatedUser> identifyUser(String email);

}
