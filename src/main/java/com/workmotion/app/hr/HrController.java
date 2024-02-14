package com.workmotion.app.hr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workmotion.app.department.DepartmentDTO;
import com.workmotion.app.department.DepartmentService;
import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.position.PositionDTO;
import com.workmotion.app.position.PositionService;
import com.workmotion.app.util.Pager;

@Controller
@RequestMapping(value = "/hr/*")
public class HrController {
	
	@Autowired
	private HrService hrService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PositionService positionService;
	
	@PostMapping("create")
	public String createMember(MemberDTO memberDTO,HttpSession session,Pager pager,Model model) throws Exception {
		hrService.createMember(memberDTO);
		List<Map<String,Object>> ar = hrService.getMemberList(memberDTO,session,pager);
		model.addAttribute("list",ar);
		return "hr/list";
	}
	
	@PostMapping("delete")
	public String deleteMember(MemberDTO memberDTO,HttpSession session,Pager pager,Model model) throws Exception {
		System.out.println(memberDTO.getId());
		int result = hrService.deleteMember(memberDTO);
		List<Map<String,Object>> ar = hrService.getMemberList(memberDTO,session,pager);
		model.addAttribute("list",ar);
		return "hr/list";
	}
	
	@GetMapping("update")
	public String updateMember(MemberDTO memberDTO,Model model,Pager pager) throws Exception {	
		pager.setPerPage(10L);
		memberDTO = hrService.getMemberDetail(memberDTO);
		List<MemberDTO> ar = departmentService.getDepartmentList(pager);
		List<PositionDTO> br = positionService.selectPosition(memberDTO);
		model.addAttribute("department",ar);
		model.addAttribute("position",br);
		model.addAttribute("dto",memberDTO);
		model.addAttribute("page","hr/update");
		return "index";
	}
	@PostMapping("update")
	public String updateMember (Model model,MemberDTO memberDTO) throws Exception {
			int result = hrService.updateMember(memberDTO);
			String msg = "수정 실패";
			if(result>0) {
				msg = "수정 성공";
			}
			model.addAttribute("msg",msg);				
			model.addAttribute("page","commons/result");
			model.addAttribute("path","/hr/list");
			return "index";		
	}
	
	@GetMapping("detail")
	public String getMemberDetail (MemberDTO memberDTO,Model model) throws Exception {
		memberDTO = hrService.getMemberDetail(memberDTO);
		model.addAttribute("dto",memberDTO);
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
