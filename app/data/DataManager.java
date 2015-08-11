package data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.activity.InvalidActivityException;

import dto.User;

public class DataManager {

	// private EntityManagerFactory entityManagerFactory =
	// Persistence.createEntityManagerFactory("defaultPersistenceUnit");
	private static DataManager instance;
	private static HashMap<Integer, User> usersMap = null;
	private static HashMap<String, Integer> index = null;
	private static int id = 5;
	private static int userlimit = 100;

	private DataManager() {
		usersMap = new HashMap<>();
		index = new HashMap<>();

		User user = new User();
		user.setUserid(1);
		user.setUsername("userone");
		user.setPassword("userone");
		user.setLatitude("0.0");
		user.setLongitude("0.0");
		user.setUpdatedat(Calendar.getInstance().getTime());

		usersMap.put(user.getUserid(), user);
		index.put(user.getUsername(), user.getUserid());

		user = new User();
		user.setUserid(2);
		user.setUsername("usertwo");
		user.setPassword("usertwo");
		user.setLatitude("0.0");
		user.setLongitude("0.0");
		user.setUpdatedat(Calendar.getInstance().getTime());

		usersMap.put(user.getUserid(), user);
		index.put(user.getUsername(), user.getUserid());

		user = new User();
		user.setUserid(3);
		user.setUsername("userthree");
		user.setPassword("userthree");
		user.setLatitude("0.0");
		user.setLongitude("0.0");
		user.setUpdatedat(Calendar.getInstance().getTime());

		usersMap.put(user.getUserid(), user);
		index.put(user.getUsername(), user.getUserid());

		user = new User();
		user.setUserid(4);
		user.setUsername("userfour");
		user.setPassword("userfour");
		user.setLatitude("0.0");
		user.setLongitude("0.0");
		user.setUpdatedat(Calendar.getInstance().getTime());

		usersMap.put(user.getUserid(), user);
		index.put(user.getUsername(), user.getUserid());

	}

	public static DataManager getInstance() {
		if (instance == null) {
			instance = new DataManager();

		}

		return instance;
	}

	public List<User> list(Integer userId) throws Exception {
		List<User> list = new ArrayList<User>();
		for (Integer id : usersMap.keySet()) {
			if (id != userId) {
				list.add(usersMap.get(id));
			}
		}

		return list;
	}

	public User get(String username, String password) throws Exception {
		User user = null;
		Integer userId = index.get(username);
		if (userId != null) {
			user = usersMap.get(userId);
			if (!user.getPassword().equals(password)) {
				user = null;
			}
		} else {
			if (index.size() < userlimit) {
				user = new User();
				user.setUserid(id++);
				user.setUsername(username);
				user.setPassword(password);
				user.setLatitude("0.0");
				user.setLongitude("0.0");
				user.setUpdatedat(Calendar.getInstance().getTime());
				usersMap.put(user.getUserid(), user);
				index.put(user.getUsername(), user.getUserid());
			} else {
				throw new InvalidActivityException("User Limit exceeded");
			}

		}
		return user;
	}

	public User update(Integer userid, String latitude, String longitude) {
		User user = null;
		try {
			user = usersMap.get(userid);
			if (user != null) {
				user.setLatitude(latitude);
				user.setLongitude(longitude);
				user.setUpdatedat(Calendar.getInstance().getTime());
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			throw exp;
		}
		return user;

	}

}
