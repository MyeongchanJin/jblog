package com.bitacademy.jblog.repository;

import java.util.Date;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class UserVo {
	@NotEmpty	//PK
	private Long userNo;
	
	@NotEmpty	//Unique
	private String id;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	@Pattern(regexp="^[0-9a-zA-Z] {5,8}$")
	private String password;
	
	@NotEmpty
	private Date joindate;

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", id=" + id + ", userName=" + userName + ", password=" + password
				+ ", joindate=" + joindate + "]";
	}
	
	
}
