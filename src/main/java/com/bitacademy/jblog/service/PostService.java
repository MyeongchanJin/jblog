package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.repository.PostVo;

public interface PostService {
	public List<PostVo> getPostList(Long cateNo);
	public List<PostVo> getPostList();
	public boolean insertPost(PostVo pvo);
}
