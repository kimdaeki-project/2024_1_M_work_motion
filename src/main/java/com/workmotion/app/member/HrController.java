package com.workmotion.app.member;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = "/hr/*")
public class HrController {

	@Autowired
	private MemberService memberService;
	
}