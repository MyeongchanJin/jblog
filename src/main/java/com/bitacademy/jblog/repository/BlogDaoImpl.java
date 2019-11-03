package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDaoImpl implements BlogDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BlogVo> selectAll() {
		List<BlogVo> list = sqlSession.selectList("blog.selectAll");
		return list;
	}
	
	@Override
	public BlogVo selectBlogUser(Long userNo) {
		BlogVo master = sqlSession.selectOne("blog.selectByUserNo", userNo);
		return master;
	}

	@Override
	public int insert(BlogVo vo) {
		int insertedCount = sqlSession.insert("blog.insert", vo);
		return insertedCount;
	}



}
