package com.bitacademy.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.exception.UserDaoException;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	public static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	SqlSession sqlSession;
	
//	@Override
//	public int insert(UserVo vo) {
//
//			int insertedCount = 0;
//			try {
//				insertedCount = sqlSession.insert("user.insert", vo);
//				logger.debug("inserted: " + vo);
//			} catch (Exception e) {
//
//				throw new UserDaoException("가입중 오류 발생", vo);
//			}
//			
//			return insertedCount;
//	}
	
	@Override
	public int insert(UserVo vo) {

			int insertedCount = sqlSession.insert("user.insert", vo);
				logger.debug("inserted: " + vo);
	
			return insertedCount;
	}
	
	
	@Override
	public int insertBlog(UserVo vo) {
		
		int insertedBlogCount = sqlSession.insert("user.insertBlog", vo);
			logger.debug("insertedBlog: " + vo);
		
		return insertedBlogCount;
	}
	

	@Override
	public UserVo selectUser(String id) {
			UserVo user = sqlSession.selectOne("user.selectById", id);
			return user;
	}

	@Override
	public UserVo selectUser(String id, String password) {

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("password", password);
		
		UserVo user = sqlSession.selectOne("user.selectByIdAndPassword", paramMap);

		return user;
	}




}
