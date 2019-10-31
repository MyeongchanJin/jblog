package com.bitacademy.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.exception.UserDaoException;

@Repository("Userdao")
public class UserDaoImpl implements UserDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(UserVo vo) {

			int insertedCount = 0;
			try {
				insertedCount = sqlSession.insert("member.insert", vo);
			} catch (Exception e) {
				//	명시적인 Exception으로 변환
				throw new UserDaoException("가입중 오류 발생", vo);
			}
			
			return insertedCount;
	}

	@Override
	public UserVo selectUser(String id) {
			UserVo user = sqlSession.selectOne("user.selectById", id);
			return user;
	}

	@Override
	public UserVo selectUser(String id, String password) {

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("email", id);
		paramMap.put("password", password);
		
		UserVo user = sqlSession.selectOne("user.selectByIdAndPassword", paramMap);

		return user;
	}
}
