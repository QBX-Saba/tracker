package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.activity.InvalidActivityException;

import data.DataManager;
import data.DataManagerDS;
import dto.User;
import dto.Users;

public class Service {

	private static Service instance;
	private static DataManagerDS dataManager;

	private Service() {
		dataManager = DataManagerDS.getInstance();
	}

	public User login(String username, String password) throws Exception{
		User user = dataManager.get(username, password);
		return user;
	}

	public Users location(String latitude, String longitude, String height, Integer userid) throws Exception{
		Users users = new Users();
		ArrayList<User> userlist = null;

		User user = dataManager.update(userid, latitude, longitude, height);
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

	public List<User> users() {
		return dataManager.users();
	}

	public User user(Integer userid) {
	
		return dataManager.getUser(userid);
	}

	public void updateUser(Integer userid, String username, String latitude,
			String longitude, String height) {
		User user = dataManager.update(userid, latitude, longitude, height);
		
	}
}
