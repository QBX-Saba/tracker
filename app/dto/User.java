package dto;

import java.util.Date;

import play.twirl.api.Content;
import util.Util;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.Required;

@Entity
@Table(name="User")
public class User implements Content {
	
	String username;
	String password;	
	Integer userid;
	String latitude;
	String longitude;
	String height;
	Date updatedat;

	
	public User(){}
	
	
	@Column(name="height")
	public String getHeight() {
		return height;
	}



	public void setHeight(String height) {
		this.height = height;
	}



	@Column(name="updatedat")
	public Date getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

	@Column(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	@GeneratedValue
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name="latitude")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name="longitude")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Transient
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

	@Transient
	@Override
	public String contentType() {

		return "application/json";
	}

}
