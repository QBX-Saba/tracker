package controllers;

import dto.User;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	Service service = Service.getInstance();
    public Result index() {
        return ok(index.render("Tracker"));
    }
    
    public Result login(String username, String password) {
    	User user = service.login(username, password);
    	if(user==null){
    		return notFound("username or password incorrect");
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
