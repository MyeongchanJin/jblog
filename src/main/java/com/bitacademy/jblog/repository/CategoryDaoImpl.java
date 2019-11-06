package com.bitacademy.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<CategoryVo> selectAllCategory() {
		List<CategoryVo> categorylist = sqlSession.selectList("category.selectAllCategory");
		return categorylist;
	}

	@Override
	public int insertCategory(CategoryVo cvo) {
		int insertedCategoryCount = sqlSession.insert("category.insertCategory", cvo);
		return insertedCategoryCount;
	}
	
	@Override
	public List<Map<String, String>> getNumOfPost(CategoryVo cvo) {
		List<Map<String, String>> postNumList = sqlSession.selectList("post.selectNumOfPost", cvo);
		return postNumList;
	}

}