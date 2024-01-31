package com.workmotion.app.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {
  @Autowired	
  private DepartmentService departmentService;
	
	public void getDepartmentList()throws Exception {
		
		
	}
	
}
