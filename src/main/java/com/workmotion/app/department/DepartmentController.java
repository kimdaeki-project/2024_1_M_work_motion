package com.workmotion.app.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	 List<MemberDTO> ar = departmentService.getDepartmentDetail(memberDTO);	
		model.addAttribute("detail", ar);
		model.addAttribute("page", "department/detail");
		return "index"; 
		
	}
	
	@GetMapping("create")
	public String createDepartment(Model model) throws Exception{
		model.addAttribute("page", "department/create");
		return "index";
	}
	
	@GetMapping("memberList")
	public String getMemberList(Pager pager, Model model) throws Exception{
		List<MemberDTO> ar = departmentService.getMemberList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("page", "department/memberList");
		MemberDTO memberDTO = new MemberDTO();
		
		return "index";
	}
	
//	@PostMapping("create")
//	public String createDepartment(Model model, MemberDTO memberDTO) throws Exception{
//		int result = departmentService.createDepartment(memberDTO);
//		String msg = "회원 추가에 실패하셨습니다";
//		if(result>0) {
//			msg="회원이 추가되었습니다";
//		}
//		model.addAttribute("msg", msg);
//		model.addAttribute("path", "/department/detail");
//		return "commons/result";
//	}
	
	
}
