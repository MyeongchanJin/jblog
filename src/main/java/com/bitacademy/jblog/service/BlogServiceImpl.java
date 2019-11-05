package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.BlogDao;
import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.UserVo;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDao blogDao;
	
	@Override
	public List<BlogVo> getList() {
		List<BlogVo> list = blogDao.selectAll();
		return list;
	}

	@Override
	public BlogVo getBlogByUserNo(Long userNo) {
		BlogVo bvo = blogDao.selectBlogUser(userNo);
		return bvo;
	}

	@Override
	public boolean write(BlogVo bvo) {
		int insertedCount = blogDao.insert(bvo);
		return 1 == insertedCount;
	}

	@Override
	public boolean updateBlogTitle(BlogVo bvo) {
		int updatedCount = blogDao.updateBlogTitle(bvo);
		return 1 == updatedCount;
	}
}
