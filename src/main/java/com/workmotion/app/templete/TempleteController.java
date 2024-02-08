package com.workmotion.app.templete;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import com.workmotion.app.document.util.Pager;
import com.workmotion.app.member.MemberDTO;

@Controller
@RequestMapping("/docTemplete/*")
public class TempleteController {
	
	@Autowired
	private TempleteService templeteService;
	
	@GetMapping("detail")
	public String getTempleteDetail(TempleteDTO templeteDTO,Model model,HttpSession session)throws Exception{
		
		    //(MemberDTO)session.getAttribute("member");
			
		templeteDTO = templeteService.getTempleteDetail(templeteDTO);		
		model.addAttribute("dto", templeteDTO);		
		
		model.addAttribute("page","docTemplete/detail");	
		return "index";
	}
	
	
	@GetMapping("list")
	public String getTempleteList(Pager pager,Model model)throws Exception {
		
		List<TempleteDTO> ar = templeteService.getTempleteList(pager);		
		model.addAttribute("templeteList", ar);
		model.addAttribute("pager",pager);
		model.addAttribute("page", "docTemplete/list");
		
		return "index";
		
	}
	
	@GetMapping("add")
	public String createTempleteAdd(Model model)throws Exception{
		model.addAttribute("page","docTemplete/add");
		return "index";
	}
	
	@PostMapping("add")
	public String createTempleteAdd(Model model,TempleteDTO templeteDTO,MultipartFile templeteFile)throws Exception{
				
		int result = templeteService.createTempleteAdd(templeteDTO, templeteFile);
		
		String msg = "등록 실패";
		
		if(result>0) {
			msg = "등록 성공";
			
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path","./list");
		return "commons/result";
		
	}
	
}
