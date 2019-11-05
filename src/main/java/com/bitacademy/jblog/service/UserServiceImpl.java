package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.UserDao;
import com.bitacademy.jblog.repository.UserVo;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean join(UserVo vo) {
		int insertedCount = userDao.insert(vo);
		return 1 == insertedCount;
	}
	
	@Override
	public boolean joinBlog(UserVo vo) {
		int insertedBlogCount = userDao.insertBlog(vo);
		return 1 == insertedBlogCount;
	}

	@Override
	public UserVo getUser(String id, String password) {
		UserVo vo = userDao.selectUser(id, password);
		return vo;
	}

	@Override
	public UserVo getUser(String id) {
		UserVo vo = userDao.selectUser(id);
		return vo;
	}



}
