package com.bitacademy.jblog.service;

import com.bitacademy.jblog.repository.UserVo;

public interface UserService {
	public boolean join(UserVo vo);
	public UserVo getUser(String id, String password);
	public UserVo getUser(String id);
}
