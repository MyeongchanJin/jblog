package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.BlogDao;
import com.bitacademy.jblog.repository.BlogVo;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDao blogDaoImpl;
	
	@Override
	public List<BlogVo> getList() {
		List<BlogVo> list = blogDaoImpl.selectAll();
		return list;
	}

	@Override
	public boolean write(BlogVo vo) {
		int insertedCount = blogDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

}
