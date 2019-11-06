package com.bitacademy.jblog.repository;

import java.util.List;

public interface PostDao {
	public List<PostVo> getPostList();
	public int write(PostVo pvo);
	public PostVo print(PostVo pvo);
	
}
