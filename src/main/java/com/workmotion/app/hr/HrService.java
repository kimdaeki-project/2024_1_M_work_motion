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
	
	
	public Map<String,Object> getMemberDetail (MemberDTO memberDTO) throws Exception {
		return hrDAO.getMemberDetail(memberDTO);
	}
	
	public List<Map<String,Object>> getMemberList (MemberDTO memberDTO,HttpSession session,Pager pager) throws Exception {	
		 MemberDTO m = (MemberDTO)session.getAttribute("member");
		 memberDTO = hrDAO.getListDetail(m);
		 Map<String,Object> ar = new HashMap<String, Object>();
		 ar.put("memberDTO",memberDTO);
		 pager.makeRow();
		 ar.put("pager",pager);
		 ar.put("kind", pager.getKind());
		 Long totalCount = hrDAO.totalCount(ar);
		 pager.makePage(totalCount);
		 ar.put("pager",pager); //°Ë»ö¾î
		return hrDAO.getMemberList(ar);	
	}
}
