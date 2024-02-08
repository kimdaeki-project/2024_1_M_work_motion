package com.workmotion.app.hr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.util.Pager;

@Controller
@RequestMapping(value = "/hr/*")
public class HrController {
	
	@Autowired
	private HrService hrService;
	
	@GetMapping("detail")
	public String getMemberDetail ( MemberDTO memberDTO,Model model) throws Exception {
		Map<String,Object> ar = hrService.getMemberDetail(memberDTO);
		model.addAttribute("dto",ar);
		model.addAttribute("page","hr/detail");
		return "index";
	}
	
	@GetMapping("list")
	public String getMemberList(HttpSession session,MemberDTO memberDTO,Model model,Pager pager) throws Exception { 
		List<Map<String,Object>> ar = hrService.getMemberList(memberDTO,session,pager);
		model.addAttribute("list",ar);
		model.addAttribute("page","hr/list");
		return "index";
	}
}
