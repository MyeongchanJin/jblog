package com.bitacademy.jblog.repository;

import java.util.List;
import java.util.Map;

public interface CategoryDao {
	public List<CategoryVo> selectAllCategory();
	public int insertCategory(CategoryVo cvo);
	public List<CategoryVo> getNumOfPost();
}