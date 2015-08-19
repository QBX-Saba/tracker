package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import play.db.jpa.*;
import dto.User;
//import java.io.Console

public class DataManagerDS {

	// private EntityManagerFactory entityManagerFactory = Persistence
	// .createEntityManagerFactory("defaultPersistenceUnit");
	private static DataManagerDS instance;

	private DataManagerDS() {

	}

	public static DataManagerDS getInstance() {
		if (instance == null) {
			instance = new DataManagerDS();

		}

		return instance;
	}

	public List<User> list(Integer userId) throws Exception {
		List<User> list = new ArrayList<User>();
		
		list = JPA
				.em()
				.createNativeQuery("select *  User where userid <>" + userId,
						User.class).getResultList();

		return list;
	}

	public User get(String username, String password) throws Exception {
		User user = null;
		
		List<User> list = JPA
				.em()
				.createNativeQuery(
						"select * from User where username ='" + username
								+ "' and password = '" + password + "'",
						User.class).getResultList();
		if (list != null & list.size() > 0) {
			user = list.get(0);
		}
		return user;
	}

	public User update(Integer userid, String latitude, String longitude) {
		User user = new User();
		user.setUserid(userid);
		
		JPA.em()
				.createNativeQuery(
						"UPDATE User set latitude = '" + latitude
								+ "' , longitude = '" + longitude
								+ "', updatedat=now() where userid = " + userid,
						User.class).executeUpdate();
		return user;

	}

	public List<User> users() {
		List<User> list = new ArrayList<User>();
		
		list = JPA.em().createNativeQuery("select * from User", User.class)
				.getResultList();

		return list;
	}

	public User getUser(Integer userid) {
		
		User user = JPA.em().find(User.class, userid);
		return user;
	}

}
