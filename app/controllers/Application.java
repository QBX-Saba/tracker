package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	Service service = Service.getInstance();
    public Result index() {
        return ok(index.render("Tracker"));
    }
    
    public Result login(String username, String password) {
        return ok(service.login(username, password));
    }
    
    public Result location(String latitude, String longitude, Integer userid) {
        return ok(service.location(latitude, longitude, userid));
    }

}
