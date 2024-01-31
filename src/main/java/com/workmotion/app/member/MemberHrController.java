package com.workmotion.app.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workmotion.app.util.Pager;

@Controller
@RequestMapping("/hr/*")
public class MemberHrController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("list")
	public void getMemberList(Pager pager,MemberDTO memberDTO,Model model) throws Exception {
		List<MemberDTO>ar = memberService.getMemberList(pager,memberDTO);
		model.addAttribute("list",ar);
		model.addAttribute("pager",pager);
	}
	@GetMapping("detail")
	public void getMemberDetail (MemberDTO memberDTO) throws Exception{
		memberService.getMemberDetail(memberDTO);
	}
	@PostMapping("update")
	public void updateMember (MemberDTO memberDTO) throws Exception{
		memberService.updateMember(memberDTO);
	}
	@PostMapping("delete")
	public void deleteMember(MemberDTO memberDTO) throws Exception {
		memberService.deleteMember(memberDTO);
	}
	@PostMapping("create")
	public void createMember(MemberDTO memberDTO)throws Exception{
		memberService.createMember(memberDTO);
	}
}
