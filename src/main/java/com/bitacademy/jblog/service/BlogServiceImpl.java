package com.bitacademy.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.jblog.repository.BlogDao;
import com.bitacademy.jblog.repository.BlogVo;

@Service
public class BlogServiceImpl implements BlogService {
	private static String SAVE_PATH = "/upload";
	private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	@Autowired
	BlogDao blogDao;
	
	@Override
	public List<BlogVo> getList() {
		List<BlogVo> list = blogDao.selectAll();
		return list;
	}

	@Override
	public BlogVo getBlogByUserNo(Long userNo) {
		BlogVo bvo = blogDao.selectBlogUser(userNo);
		return bvo;
	}

	@Override
	public boolean write(BlogVo bvo) {
		int insertedCount = blogDao.insert(bvo);
		return 1 == insertedCount;
	}

	@Override
	public boolean updateBlog(BlogVo bvo) {
		int updatedCount = blogDao.updateBlog(bvo);
		return 1 == updatedCount;
	}

	@Override
	public String storeFile(MultipartFile mFile, BlogVo bvo) {
		//	실제 클라이언트에서의 파일 이름
		//	Need Rename
		//	Rename이 필요할 것 같음
		String subName = "";
		String savedFilename = "";
		
		String originalFilename = mFile.getOriginalFilename();
		//String originalFilename = blogDao.
		Long size = mFile.getSize();
		
		logger.debug("원본 파일명: " + originalFilename);
		logger.debug("파일의 사이즈: " + size);
				
		//	Multipart Resolver 6-5. Renaming(Duplicate Preventation)
		//	Multipart Resolver 6-5-1. Remane, Substring
		//	파일명 변경, 확장자 분리
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		String realName = originalFilename.substring(0, originalFilename.lastIndexOf(".")).toLowerCase();
		
		logger.debug("파일의 확장자: " + extName);
		logger.debug("파일의 이름: " + realName);
		//	Multipart Resolver 6-5-2. Duplicate Preventation
		//	파일명 생성(시스템 날짜를 이용하여 중복방지)
		Calendar cal = Calendar.getInstance();
		subName = String.valueOf(cal.getTimeInMillis());
		savedFilename = realName + "_" + subName + extName;
		logger.debug("새로 만든 파일명: " + savedFilename);
		
		bvo.setLogoFile(savedFilename);
		
		try {
			//	Multipart Resolver 6-4. Save File Exception
			//	Multipart Resolver 6-5-3. Change Filename to Saved Filename
			//writeFile(mFile, originalFilename);
			writeFile(mFile, savedFilename, bvo);
		} catch (Exception e) {
			throw new RuntimeException(e);
			//	익셉션의 전환 : 커스텀 익셉션 만들어 처리할 것을 권장
		}
		//return originalFilename;
		return savedFilename;
	}

	@Override
	public void writeFile(MultipartFile mFile, String saveFilename, BlogVo bvo) throws IOException {
		byte[] fileData = mFile.getBytes();
		
		int updatedCount = blogDao.updateBlog(bvo);
		
		//	저장을 위해 FileOutputStream을 생성
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		fos.write(fileData);
		fos.close();
	}
}
