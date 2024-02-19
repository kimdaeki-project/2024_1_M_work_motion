package com.workmotion.app.product;

import java.util.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
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

import com.workmotion.app.company.CompanyDTO;
import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("list")
	public String getList(Pager pager, Model model)throws Exception {
		 List<ProductDTO> ar = productService.getList(pager);
		 
		 
		 LocalDateTime startDate = LocalDateTime.of(2024, 02, 19, 06, 8);
		 LocalDateTime lastDate = LocalDateTime.of(2024, 02, 19, 06, 8);
		 
		 LocalDateTime plusDate = startDate.plusHours(06);
		 startDate.isAfter(plusDate);
		System.out.println(plusDate);
		 model.addAttribute("list", ar);
		 model.addAttribute("page", "product/list");
		 model.addAttribute("pager", pager);
		 
		 return "index";
	}
	

	@GetMapping("detail")
	public String getDetail(ProductDTO productDTO, Model model) throws Exception{
		
	productDTO = productService.getDetail(productDTO);
	
	model.addAttribute("detail", productDTO);
	model.addAttribute("page", "/product/detail");
	System.out.println(productDTO.getPeriod());
	return "index";
		
	}

	@PostMapping("payment")
	public String payment(HttpSession session,ProductDTO productDTO,Model model) throws Exception{
		 MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		 CompanyDTO companyDTO = new CompanyDTO();
		 companyDTO = productService.getPaymentDetail(memberDTO);
		System.out.println(productDTO.getPeriod());
		 model.addAttribute("product", productDTO);
		model.addAttribute("company", companyDTO);
		model.addAttribute("page", "/commons/payment");
		return "index";
		
	}
}
