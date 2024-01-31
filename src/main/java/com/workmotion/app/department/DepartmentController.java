package com.workmotion.app.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.util.Pager;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {
  @Autowired	
  private DepartmentService departmentService;
	@GetMapping("list")
	public String getDepartmentList(Pager pager, Model model)throws Exception {
		
		List<MemberDTO> ar = departmentService.getDepartmentList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		model.addAttribute("page", "department/list");
		return "index";
		
	}
	@GetMapping("detail")
	public String getDepartmentDetail(DepartmentDTO departmentDTO, Model model)throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setDepartment_id(departmentDTO.getId());
	 memberDTO = departmentService.getDepartmentDetail(memberDTO);	
		model.addAttribute("detail", memberDTO);
		model.addAttribute("page", "department/detail");
		return "index"; 
		
	}
	
	
}
