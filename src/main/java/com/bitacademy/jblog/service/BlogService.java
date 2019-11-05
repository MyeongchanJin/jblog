package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.repository.BlogVo;

public interface BlogService {
	public List<BlogVo> getList();
	public BlogVo getBlogByUserNo(Long userNo);
	public boolean write(BlogVo bvo);
	public boolean updateBlogTitle(BlogVo bvo);
}
