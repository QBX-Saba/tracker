package dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.twirl.api.Content;
import util.Util;


public class User implements Content{
	String username;
	String password;
	Integer userid;
	String latitude;
	String longitude;
	
	

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String body() {
		String json = null;
		try {
			json = Util.jsonmapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public String contentType() {
		
		return "application/json";
	}
	
	

}
