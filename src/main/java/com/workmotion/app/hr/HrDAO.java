package com.workmotion.app.hr;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workmotion.app.member.MemberDTO;

@Repository
public class HrDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.workmotion.app.hr.HrDAO.";
	
	public Long totalCount(Map<String,Object> map) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"totalCount", map);
	}
	
	public List<Map<String,Object>> getMemberList (Map<String,Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getMemberList",map);
	}
	
	public MemberDTO getMemberDetail(MemberDTO memberDTO)throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getMemberDetail",memberDTO);
	}
	
}
