package com.workmotion.app.member;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	
	@ResponseBody
	@GetMapping("emailcheck")
	public int getemailcheck(MemberDTO memberDTO,Model model) throws Exception {
		int result = 0;	
		memberDTO = memberService.emailCheck(memberDTO);
		if(memberDTO==null){
			result = 1;
		}
		model.addAttribute("result",result);
		return result;
	}
	
	
	@GetMapping("agree")
	public void getagree()throws Exception {
	}
	
	
	@GetMapping("logout")
	public String getlogout(HttpSession session,Model model)throws Exception {
		session.invalidate();
		return "/member/login";
	}
	
  
	@GetMapping("login")
	public void getlogin()throws Exception{	
	}
	@PostMapping("login")
	public String getlogin(MemberDTO memberDTO,HttpSession session,Model model)throws Exception{
		memberDTO = memberService.getlogin(memberDTO);
		
		  if(memberDTO==null) {
			  model.addAttribute("msg","ID PW CHECK");
			  return"member/login";
		  }else {
			  session.setAttribute("member",memberDTO);
			  model.addAttribute("page","home");
			  return "index";
		  }
		
	}
	
	@PostMapping("join")
	public String getjoin(MemberDTO memberDTO,Model model)throws Exception{

		int result =  memberService.getjoin(memberDTO);
		
		return "member/join";
	}
	
	@GetMapping("join")
	public String getjoin(Model model)throws Exception{
		model.addAttribute("page","member/join");
		return "member/join";
	}
	
	
	
	
	@GetMapping("mypage")
	public String mypage(HttpSession session,Model model)throws Exception {
		MemberDTO m = (MemberDTO)session.getAttribute("member");
		MemberDTO memberDTO = memberService.detailMember(m);
		model.addAttribute("dto",memberDTO);
		model.addAttribute("page","member/mypage");
		return "index";
	}
	
	
	@PostMapping("update")
	public String getupdate(MemberDTO memberDTO,Model model,MultipartFile picture) throws Exception { 
		int result = memberService.updateMember(memberDTO);
				     memberService.setFileAdd(memberDTO,picture);
		 model.addAttribute("page","home");
		 return "index";
	}
	
}
