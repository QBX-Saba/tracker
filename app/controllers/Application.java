package controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import dto.User;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	Service service = Service.getInstance();

	public Result index() {
		return ok(index.render("Tracker"));
	}
	
	public Result users() {
		List<User> usersList = service.users();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		return ok(users.render(usersList, simpleDateFormat));
	}
	
	public Result updateuser(Integer userid, String username, String password, String latitude, String longitude) {
		service.updateUser(userid, username, latitude, longitude);
		return redirect("/users");
	}
	
	public Result user(Integer userid) {
		User user = service.user(userid);
		return ok(edituser.render(user));
	}

	public Result login(String username, String password) {
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

	public Result location(String latitude, String longitude, Integer userid) {
		try {
			return ok(service.location(latitude, longitude, userid));
		} catch (Exception e) {
			return badRequest(e.getLocalizedMessage());
		}
	}

}
