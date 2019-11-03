package com.bitacademy.jblog.repository;

import java.util.List;

public interface BlogDao {
	public List<BlogVo> selectAll();
	public BlogVo selectBlogUser(Long no);
	public int insert(BlogVo vo);
}
