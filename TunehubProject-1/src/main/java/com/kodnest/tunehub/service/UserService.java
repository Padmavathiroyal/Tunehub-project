package com.kodnest.tunehub.service;


import com.kodnest.tunehub.entity.User;

public interface UserService {


	String getRole(String email);
	boolean emailExists(User user);
	void saveUser(User user);
	boolean validUser(String email, String password);
	User getUser(String mail);
	void updateUser(User user);

}