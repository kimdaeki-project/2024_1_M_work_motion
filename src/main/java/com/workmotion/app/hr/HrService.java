package com.workmotion.app.hr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.util.Pager;

@Service
public class HrService {

	@Autowired
	private HrDAO hrDAO;
	
	

	
	public List<Map<String,Object>> getMemberList (MemberDTO memberDTO,HttpSession session,Pager pager) throws Exception {	
		 MemberDTO m = (MemberDTO)session.getAttribute("member");
		 memberDTO = hrDAO.getMemberDetail(m);
		 pager.makeRow();
		 Long totalCount = hrDAO.totalCount(memberDTO);
		 pager.makePage(totalCount);
		 Map<String,Object> ar = new HashMap<String, Object>();
		 ar.put("memberDTO",memberDTO);
		 ar.put("pager",pager);
		return hrDAO.getMemberList(ar);	
	}
}
