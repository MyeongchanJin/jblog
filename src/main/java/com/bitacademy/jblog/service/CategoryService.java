package com.bitacademy.jblog.service;

import java.util.List;
import java.util.Map;

import com.bitacademy.jblog.repository.CategoryVo;

public interface CategoryService {
	public List<CategoryVo> getCategoryList(Long userNo);
	public boolean insertCategory(CategoryVo cvo);
	public List<CategoryVo> getPostNum();
}
