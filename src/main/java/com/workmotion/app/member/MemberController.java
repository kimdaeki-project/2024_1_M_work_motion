package com.workmotion.app.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("logout")
	public String getlogout(HttpSession session,Model model)throws Exception {
		session.invalidate();
		
		return "redirect:member/login";
	}
	
	@GetMapping("login")
	public void getlogin()throws Exception{
		
	}
	@PostMapping("login")
	public String getlogin(MemberDTO memberDTO,HttpSession session,Model model)throws Exception{
		
		memberDTO = memberService.getlogin(memberDTO);
		
		  if(memberDTO==null) {
			  model.addAttribute("msg","아이이디 또는 비밀번호를 확인하세요");
			
	
			  return"member/login";
		  }else {
			  session.setAttribute("member",memberDTO);
			  model.addAttribute("page","home");
			  return "index";
			  
		  }
		  
		
	}
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
