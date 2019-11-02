package com.bitacademy.jblog.repository;

public interface UserDao {
	public int insert(UserVo vo);
	public int insertBlog(UserVo vo);
	public UserVo selectUser(String id);
	public UserVo selectUser(String id, String password);
	
}

