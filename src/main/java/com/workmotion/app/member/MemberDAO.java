package com.workmotion.app.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.workmotion.app.member.MemberDAO.";
	
	
	
	public MemberDTO detailMember(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detailMember",memberDTO);
	}

	public int updateMember(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"updateMember",memberDTO);
	}

	public int createMember(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"createMember",memberDTO);
	}
	
	
}
