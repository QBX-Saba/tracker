package dto;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;

import play.twirl.api.Content;
import util.Util;

public class Users implements Content {
	ArrayList<User> users;

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public String body() {
		String json = null;
		try {
			json = Util.jsonmapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public String contentType() {

		return "application/json";
	}

}
