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

	
	
	
	
	//로그아웃
	@GetMapping("logout")
	public String getlogout(HttpSession session,Model model)throws Exception {
		session.invalidate();
		return "member/login";
	}
	
    //로그인
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
	//회원가입
	@PostMapping("join")
	public String getjoin(MemberDTO memberDTO,Model model)throws Exception{

		int result =  memberService.getjoin(memberDTO);
		model.addAttribute("page","member/login");
		return "index";
	}
	//회원가입
	@GetMapping("join")
	public String getjoin(Model model)throws Exception{
		model.addAttribute("page","member/join");
		return "member/join";
	}
	
	
	
	//마이페이지
	@GetMapping("mypage")
	public String mypage(HttpSession session,Model model)throws Exception {
		MemberDTO m = (MemberDTO)session.getAttribute("member");
		model.addAttribute("page","member/mypage");
		return "index";
	}
	
	//마이페이지 정보수정
	@PostMapping("update")
	public String getupdate(MemberDTO memberDTO,HttpSession session,Model model) throws Exception { 
		memberService.detailMember(memberDTO);
		int result = memberService.updateMember(memberDTO);
		 model.addAttribute("page","home");
		 return "index";
	}
	
}
