package com.workmotion.app.tosspayment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TossPaymentDAO {
	@Autowired
	private SqlSession sqlSession;
	private String namespace="com.workmotion.app.tosspayment.TossPaymentDAO";
	
}
