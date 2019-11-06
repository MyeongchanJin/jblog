package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CategoryDao;
import com.bitacademy.jblog.repository.CategoryVo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<CategoryVo> getCategoryList() {
		List<CategoryVo> categoryList = categoryDao.selectAllCategory();
		return categoryList;
	}

	@Override
	public boolean insertCategory(CategoryVo cvo) {
		int insertedCategoryCount = categoryDao.insertCategory(cvo);
		return 1 == insertedCategoryCount;
	}

}
