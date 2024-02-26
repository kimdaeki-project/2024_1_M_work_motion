package com.workmotion.app.errors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error/*")
public class ErrorController {

	@GetMapping("error404")
	public String Error404(Model model) {
		model.addAttribute("page", "errors/error");
		model.addAttribute("error", "404");
		return "index";
	}

	@GetMapping("error404")
	public String Error400(Model model) {
		model.addAttribute("page", "errors/error");
		model.addAttribute("error", "400");
		return "index";
	}
	
	@GetMapping("error403")
	public String Error403(Model model) {
		model.addAttribute("page", "errors/error");
		model.addAttribute("error", "403");
		return "index";
	}
	
	@GetMapping("error500")
	public String Error500(Model model) {
		model.addAttribute("page", "errors/error");
		model.addAttribute("error", "500");
		return "index";
	}
}
