package com.workmotion.app.templete;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workmotion.app.document.util.MemberDTO;
import com.workmotion.app.document.util.Pager;

@Repository
public class TempleteDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.workmotion.app.templete.TempleteDAO.";
	
	public List<TempleteDTO> getTempleteList(Pager pager)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getTempleteList", pager);
		
	}
	
	public Long getTotalCount(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	public int createTempleteAdd(TempleteDTO templeteDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"createTempleteAdd", templeteDTO);
	}
	public TempleteDTO getTempleteDetail(TempleteDTO templeteDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTempleteDetail", templeteDTO);
	}


	

}
