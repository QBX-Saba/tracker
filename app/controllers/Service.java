package controllers;

import java.util.ArrayList;

import javax.activity.InvalidActivityException;

import data.DataManager;
import dto.User;
import dto.Users;

public class Service {

	private static Service instance;
	private static DataManager dataManager;

	private Service() {
		dataManager = DataManager.getInstance();
	}

	public User login(String username, String password) {
		User user = dataManager.get(username, password);

		return user;
	}

	public Users location(String latitude, String longitude, Integer userid) throws Exception{
		Users users = new Users();
		ArrayList<User> userlist = null;

		User user = dataManager.update(userid, latitude, longitude);
		if (user != null) {
			userlist = (ArrayList<User>) dataManager.list(userid);
		} else {
			throw new InvalidActivityException("No such user exists");
		}

		users.setUsers(userlist);
		return users;
	}

	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}
}
