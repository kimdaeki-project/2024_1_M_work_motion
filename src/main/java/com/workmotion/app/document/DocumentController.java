package com.workmotion.app.document;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/document/*")
public class DocumentController {
	
	@PostMapping("add")
	public void createDocument(MultipartFile[] file)throws Exception{
		System.out.println("연결됨");
		
		
		
	}

}
