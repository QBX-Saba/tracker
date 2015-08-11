package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Tracker"));
    }
    
    public Result login(String username, String password) {
        return ok(index.render("Your new application is ready."));
    }
    public Result location(String latitude, String longitude, Integer userid) {
        return ok(index.render("Your new application is ready."));
    }

}
