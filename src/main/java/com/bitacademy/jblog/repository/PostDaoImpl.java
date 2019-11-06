package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<PostVo> getPostList() {
		List<PostVo> postList = sqlSession.selectList("post.selectAllPost");
		return postList;
	}
	
	@Override
	public int write(PostVo pvo) {
		int insertedPostCount = sqlSession.insert("post.insertPost", pvo);
		return insertedPostCount;
	}

	@Override
	public PostVo print(PostVo pvo) {
		// TODO Auto-generated method stub
		return null;
	}





}
