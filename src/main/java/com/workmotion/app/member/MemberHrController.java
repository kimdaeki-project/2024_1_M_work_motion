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
@RequestMapping(value = "/hr/*")
public class MemberHrController {

	@Autowired
	private MemberService memberService;
	
//	@GetMapping("list")
//	public String getMemberList(Pager pager,MemberDTO memberDTO,Model model) throws Exception {
//		List<MemberDTO>ar = memberService.getMemberList(pager,memberDTO);
//		model.addAttribute("list",ar);
//		model.addAttribute("pager",pager);
//		return "/";
//	}

//	@PostMapping("update")
//	public String updateMember (MemberDTO memberDTO,Model model) throws Exception{
//		int result =  memberService.updateMember(memberDTO);
//		return "/";
//	}
//	@PostMapping("delete")
//	public String deleteMember(MemberDTO memberDTO,Model model) throws Exception {
//		int result =  memberService.deleteMember(memberDTO);
//		return "/";
//	}
	
	@PostMapping("create")
	public String createMember(MemberDTO memberDTO,Model model)throws Exception{
		System.out.println("email :" +memberDTO.getEmail());
		int result =  memberService.createMember(memberDTO);
		System.out.println("email :" +memberDTO.getEmail());
		model.addAttribute("page","hr/create");
		return "index";
	}
	@GetMapping("create")
	public String createMember(Model model)throws Exception{
		model.addAttribute("page","hr/create");
		return "hr/create";
	}
}
