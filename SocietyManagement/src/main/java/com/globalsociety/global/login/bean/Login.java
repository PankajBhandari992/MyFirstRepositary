package com.globalsociety.global.login.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN_DETAILS")
@SequenceGenerator(name="Login_sequence", sequenceName = "Login_Details_sequence" ,initialValue=1, allocationSize=2	)
public class Login {
	
	
	public Login() {}
	
	public Login(long loginPk, String userName, String password) {
		super();
		this.loginPk = loginPk;
		this.username = userName;
		this.password = password;
	}

	@Id
	@Column(name="LOGIN_PK" ,nullable=false,updatable= false	)
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="Login_sequence")
	private long loginPk;
	
	@Column(name="username" , unique=true)
	private String username;
	
	@Column(name="password")
	private String password;

	public long getLoginPk() {
		return loginPk;
	}

	public void setLoginPk(long loginPk) {
		this.loginPk = loginPk;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
