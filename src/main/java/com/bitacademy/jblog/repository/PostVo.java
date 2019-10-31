package com.bitacademy.jblog.repository;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class PostVo {
	
	//PK
	private Long postNo;
	
	//FK
	private Long cateNo;
	
	@NotEmpty
	private String postTitle;
	
	private String postContent;
	
	@NotEmpty
	private Date regDate;

	public Long getPostNo() {
		return postNo;
	}

	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}

	public Long getCateNo() {
		return cateNo;
	}

	public void setCateNo(Long cateNo) {
		this.cateNo = cateNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "PostVo [postNo=" + postNo + ", cateNo=" + cateNo + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", regDate=" + regDate + "]";
	}

	
}
