package com.faiz.multiple.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private int id;
	@Column(name = "USER_NAME")
	private String userName;

	public User() {
		super();
	}

	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
