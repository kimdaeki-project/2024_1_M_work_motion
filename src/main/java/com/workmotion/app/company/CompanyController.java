package com.workmotion.app.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.util.Pager;

@Controller
@RequestMapping("/company/*")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	// 컴퍼니 리스트@@@@@@@@@@@@@
	@GetMapping("list")
	public String getCompanyList(Pager pager, Model model) throws Exception {
		List<CompanyDTO> ar = companyService.getCompanyList(pager);

		model.addAttribute("list", ar);
		model.addAttribute("page", "company/list");

		return "manager";
	}

	// 컴퍼니 추가@@@@@@@@@@@@@@
	@GetMapping("create")
	public String createCompany(Model model) throws Exception {

		model.addAttribute("page", "/company/create");

		return "manager";

	}

	// 컴퍼니(Post) 추가@@@@@@@@@@@@@@@@
	@PostMapping("create")
	public String createCompany(CompanyDTO companyDTO, Model model) throws Exception {
		int result = companyService.createCompany(companyDTO);

		String msg = "실패";
		if (result > 0) {
			msg = "성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", "/company/list");

		return "commons/result";
	}

	// 컴퍼니 수정리스트@@@@@@@@@@@@@
	@GetMapping("updateList")
	public String companyUpdateList(Pager pager, Model model) throws Exception {
		List<CompanyDTO> ar = companyService.getCompanyList(pager);

		model.addAttribute("list", ar);
		model.addAttribute("page", "company/updateList");

		return "manager";
	}

	// 컴퍼니 수정@@@@@@@@@@@@@@@@
	@GetMapping("update")
	public String companyUpdate(CompanyDTO companyDTO, Model model) throws Exception {

		companyDTO = companyService.getCompanyDetail(companyDTO);

		model.addAttribute("detail", companyDTO);
		model.addAttribute("page", "/company/update");

		return "manager";
	}

	// 컴퍼니 수정(Post)@@@@@@@@@@@@@@@@@@@@@@@
	@PostMapping("update")
	public String updatePost(CompanyDTO companyDTO, Model model) throws Exception {
		
		System.out.println(companyDTO.getId());
		int result = companyService.CompanyUpdate(companyDTO);
		
		String msg = "실패";
		if (result > 0) {
			msg = "성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", "/company/list");
		
		return "commons/result";

	}
	//컴퍼니 삭제@@@@@@@@@@@@@@
	@ResponseBody
	@PostMapping("delete")
	public int companyDelete(Long [] id, Model model)throws Exception {
		
		CompanyDTO companyDTO = new CompanyDTO();
		int result=0;
		for(Long a : id) {
			System.out.println(a);
			companyDTO.setId(a);
			result = companyService.companyDelete(companyDTO);
		}
		
		return result;
	}
	//컴퍼니 디테일@@@@@@@@@@@@@@@@@@
	@GetMapping("detail")
	public String companyDetail(CompanyDTO companyDTO, Model model)throws Exception{
		Long totalCount= companyDTO.getId();
		totalCount = companyService.memberTotalCount(totalCount);
		model.addAttribute("member", totalCount);
		companyDTO = companyService.getCompanyDetail(companyDTO);
		model.addAttribute("detail", companyDTO);
		model.addAttribute("page", "/company/detail");
		
		return "manager";
	}

}
