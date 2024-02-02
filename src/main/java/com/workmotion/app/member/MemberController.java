package com.workmotion.app.member;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	//이메일 중복확인
	@ResponseBody
	@GetMapping("emailcheck")
	public int getemailcheck(MemberDTO memberDTO,Model model) throws Exception {
		int result = 0;	
		memberDTO = memberService.emailCheck(memberDTO);
		if(memberDTO==null){
			result = 1;
		}
		return result;
	}
	
	//동의약관
	@GetMapping("agree")
	public void getagree()throws Exception {
	}
	
	//로그아웃
	@GetMapping("logout")
	public String getlogout(HttpSession session,Model model)throws Exception {
		session.invalidate();
		return "/member/login";
	}
	
    //로그인
	@GetMapping("login")
	public void getlogin()throws Exception{	
	}
	@PostMapping("login")
	public String getlogin(MemberDTO memberDTO,HttpSession session,Model model)throws Exception{
		memberDTO = memberService.getlogin(memberDTO);
		
		  if(memberDTO==null) {
			  model.addAttribute("msg","아이디 비번을 확인해주세요");
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
		
		return "member/join";
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
		MemberDTO memberDTO = memberService.detailMember(m);
		model.addAttribute("dto",memberDTO);
		model.addAttribute("page","member/mypage");
		return "index";
	}
	
	//정보수정
	@PostMapping("update")
	public String getupdate(MemberDTO memberDTO,Model model) throws Exception { 
		int result = memberService.updateMember(memberDTO);
		 model.addAttribute("page","home");
		 return "index";
	}
	
}
