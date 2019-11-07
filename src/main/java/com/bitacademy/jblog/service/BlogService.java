package com.bitacademy.jblog.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.jblog.repository.BlogVo;

public interface BlogService {
	public List<BlogVo> getList();
	public BlogVo getBlogByUserNo(Long userNo);
	public boolean write(BlogVo bvo);
	public boolean updateBlog(BlogVo bvo);
	public String storeFile(MultipartFile mFile, BlogVo bvo);
	public void writeFile(MultipartFile mFile, String saveFilename, BlogVo bvo) throws IOException;
}
