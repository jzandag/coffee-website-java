package com.coffee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.directwebremoting.annotations.DataTransferObject;

import com.coffee.base.BaseModel;
import com.coffee.util.InventoryUtility;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
@DataTransferObject
public class Users extends BaseModel implements Serializable {

	private Long id;
	private String username;
	private String email;
	private String password;
	private String role;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Transient
	public String getEmailDesc() {

		String param = "";

		if (!InventoryUtility.isEmpty(email)) {
			Integer len = email.length();
			if (len > 20) {
				param = email.substring(0, 20) + " ...";
			} else {
				param = email;
			}
		}
		
		return param;
	}
}
