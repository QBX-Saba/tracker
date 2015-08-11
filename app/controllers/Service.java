package controllers;

import dto.User;
import dto.Users;

public class Service {

	public User login(String username, String password) {
		User user = new User();
		return user;
	}

	public Users location(String latitude, String longitude, Integer userid) {
		Users users = new Users();
		return users;
	}
}
