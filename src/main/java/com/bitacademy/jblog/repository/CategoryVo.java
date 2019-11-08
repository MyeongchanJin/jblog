package com.bitacademy.jblog.repository;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class CategoryVo {
	//PK
	private Long cateNo;
	
	//FK
	private Long userNo;
	
	@NotEmpty
	private String cateName;
	
	private String description;
	
	private String postNum;
	
	private String regDateToChar;
	
	@NotEmpty
	private Date regDate;

	public Long getCateNo() {
		return cateNo;
	}

	public void setCateNo(Long cateNo) {
		this.cateNo = cateNo;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getRegDateToChar() {
		return regDateToChar;
	}

	public void setRegDateToChar(String regDateToChar) {
		this.regDateToChar = regDateToChar;
	}

	@Override
	public String toString() {
		return "CategoryVo [\ncateNo=" + cateNo + "\nuserNo=" + userNo + "\ncateName=" + cateName + "\ndescription="
				+ description + "\npostNum=" + postNum + "\nregDateToChar=" + regDateToChar + "\nregDate=" + regDate
				+ "\n]";
	}

	
}

