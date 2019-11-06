package com.bitacademy.jblog.repository;

import java.util.List;

public interface CategoryDao {
	public List<CategoryVo> selectAllCategory();
	public int insertCategory(CategoryVo cvo);
}