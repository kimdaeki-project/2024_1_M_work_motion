package com.workmotion.app.tosspayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TossPaymentService {
	@Autowired
	private TossPaymentDAO tossPaymentDAO;
	
}
