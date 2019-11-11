package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CategoryVo;
import com.bitacademy.jblog.repository.PostDao;
import com.bitacademy.jblog.repository.PostVo;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao postDao;
	
	@Override
	public List<PostVo> getPostList(Long cateNo) {
		List<PostVo> postList = postDao.getPostList(cateNo);
		return postList;
	}
	
	@Override
	public boolean insertPost(PostVo pvo) {
		int insertedPostCount = postDao.write(pvo);
		return 1 == insertedPostCount;
	}

	@Override
	public List<PostVo> getPostList() {
		List<PostVo> postList = postDao.getPostList();
		return postList;
	}





}
