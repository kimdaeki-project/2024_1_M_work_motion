package com.workmotion.app.document;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workmotion.app.document.file.DocumentFileDTO;
import com.workmotion.app.referrer.ReferrerDTO;

@Repository
public class DocumentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.workmotion.app.document.DocumentDAO.";
	
	public int createDocument(DocumentDTO documentDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"createDocument", documentDTO);
	}
	
	public int createFiles(DocumentFileDTO fileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"createFiles", fileDTO);
	}
	
	public int createReferrer(ReferrerDTO referrerDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"createReferrer", referrerDTO);
	}


}
