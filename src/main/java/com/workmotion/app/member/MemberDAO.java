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
	
	
	public List<MemberDTO> getMemberList(Map<String,Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getMemberList",map);
	}
	public int getMemberDetail(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getMemberList",memberDTO);
	}

	public int updateMember(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"updateMember",memberDTO);
	}

	public int deleteMember(MemberDTO memberDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"deleteMember",memberDTO);
	}
	public int createMember(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"createMember",memberDTO);
	}
	
}
