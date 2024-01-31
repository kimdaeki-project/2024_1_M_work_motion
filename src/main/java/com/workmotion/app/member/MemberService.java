package com.workmotion.app.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workmotion.app.util.Pager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public List<MemberDTO> getMemberList (Pager pager,MemberDTO memberDTO) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pager",pager);
		map.put("memberDTO",memberDTO);
		return memberDAO.getMemberList(map);
	}
	public int getMemberDetail(MemberDTO memberDTO) throws Exception {
	return 	memberDAO.getMemberDetail(memberDTO);
	}
	public int updateMember(MemberDTO memberDTO) throws Exception {
		return	memberDAO.updateMember(memberDTO);
	}
	public int deleteMember(MemberDTO memberDTO) throws Exception {
		return memberDAO.deleteMember(memberDTO);
	}
	public int createMember(MemberDTO memberDTO) throws Exception {
		return memberDAO.createMember(memberDTO);
	}
}
