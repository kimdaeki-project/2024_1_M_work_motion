package com.workmotion.app.tna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workmotion.app.member.MemberDTO;

@Service
public class TnaService {
	@Autowired	
	private TnaDAO tnaDAO;
	
	public int getinTna (MemberDTO memberDTO) throws Exception {
		return tnaDAO.getinTna(memberDTO);
	}
	
	public int getoutTna(MemberDTO memberDTO) throws Exception {
		return tnaDAO.getoutTna(memberDTO);
	}
}
