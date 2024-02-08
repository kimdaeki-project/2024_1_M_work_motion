package com.workmotion.app.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private String namespace= "com.workmotion.app.board.BoardDAO.";
}
