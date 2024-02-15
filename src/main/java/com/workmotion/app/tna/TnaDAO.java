package com.workmotion.app.tna;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workmotion.app.member.MemberDTO;

@Repository
public class TnaDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.workmotion.app.tna.TnaDAO.";
	
	public int getinTna (MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"getinTna",memberDTO);
	}
	public int getoutTna (MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"getoutTna",memberDTO);
	}
}
