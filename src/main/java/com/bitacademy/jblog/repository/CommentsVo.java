package com.bitacademy.jblog.repository;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class CommentsVo {
	
	//PK
	private Long cmtNo;
	
	//FK
	private Long postNo;
	
	//FK
	private Long userNo;
	
	@NotEmpty
	private String cmtContent;
	
	@NotEmpty
	private Date regDate;

	public Long getCmtNo() {
		return cmtNo;
	}

	public void setCmtNo(Long cmtNo) {
		this.cmtNo = cmtNo;
	}

	public Long getPostNo() {
		return postNo;
	}

	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getCmtContent() {
		return cmtContent;
	}

	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CommentsVo [cmtNo=" + cmtNo + ", postNo=" + postNo + ", userNo=" + userNo + ", cmtContent=" + cmtContent
				+ ", regDate=" + regDate + "]";
	}
}
