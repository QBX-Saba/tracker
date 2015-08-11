package controllers;

import java.util.ArrayList;

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

	public Users location(String latitude, String longitude, Integer userid) {
		Users users = new Users();
		ArrayList<User> userlist=null;
		try {
			dataManager.update(userid, latitude, longitude);
			userlist = (ArrayList<User>) dataManager.list(userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
