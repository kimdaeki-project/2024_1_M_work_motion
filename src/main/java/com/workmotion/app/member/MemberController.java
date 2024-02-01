package com.workmotion.app.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("logout")
	public String getlogout(HttpSession session,Model model)throws Exception {
		session.invalidate();
		
		return "member/login";
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

		int result =  memberService.createMember(memberDTO);
		model.addAttribute("page","home");
		return "index";
	}
	@GetMapping("create")
	public String createMember(Model model)throws Exception{
		model.addAttribute("page","member/create");
		return "member/create";
	}
	
	@GetMapping("mypage")
	public String getmypage(HttpSession session,Model model)throws Exception {
		MemberDTO m = (MemberDTO)session.getAttribute("member");
		System.out.println(m.getEmail());
		memberService.updateMember(m);
		model.addAttribute("page","member/mypage");
		return "index";
	}
	
	@PostMapping("update")
	public String updateMember(MemberDTO memberDTO,Model model,MultipartFile file) throws Exception { 
		int result = memberService.updateMember(memberDTO);
		 
		 model.addAttribute("page","home");
		 return "index";
	}
	
}
