package com.mspandrade.firebasegateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotBlank
	@Column(unique=true)
	private String username;
	@Column(unique=true)
	private String email;
	@JsonIgnore
	private String password;
	
	public User() {}
	
	public User(String username,String email,String password) {
		setUsername(username);
		setEmail(email);
		setPassword(password);
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter("password")
	public void setPassword(String password) {
		this.password = password;
	}
	
}
