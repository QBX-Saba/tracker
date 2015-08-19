package controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import dto.User;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	private static Service service = Service.getInstance();

	@play.db.jpa.Transactional
	public static Result index() {
		return ok(index.render("Tracker"));
	}
	
	@play.db.jpa.Transactional
	public static Result users() {
		List<User> usersList = service.users();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		return ok(users.render(usersList, simpleDateFormat));
	}
	
	@play.db.jpa.Transactional
	public static Result updateuser(Integer userid, String username, String password, String latitude, String longitude, String height) {
		service.updateUser(userid, username, latitude, longitude, height);
		return redirect("/users");
	}
	
	@play.db.jpa.Transactional
	public static Result user(Integer userid) {
		User user = service.user(userid);
		return ok(edituser.render(user));
	}

	@play.db.jpa.Transactional
	public static Result login(String username, String password) {
		User user = null;
		try {
			user = service.login(username, password);

			if (user == null) {
				return notFound("username or password incorrect");
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			return badRequest(exp.getLocalizedMessage());

		}
		return ok(user);
	}

	@play.db.jpa.Transactional
	public static Result location(String latitude, String longitude, String height, Integer userid) {
		try {
			return ok(service.location(latitude, longitude, height, userid));
		} catch (Exception e) {
			return badRequest(e.getLocalizedMessage());
		}
	}

}
