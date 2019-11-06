package com.bitacademy.jblog.service;

import java.util.List;
import java.util.Map;

import com.bitacademy.jblog.repository.CategoryVo;

public interface CategoryService {
	public List<CategoryVo> getCategoryList();
	public boolean insertCategory(CategoryVo cvo);
	public List<Map<String, String>> getPostNum(CategoryVo cvo);
}
