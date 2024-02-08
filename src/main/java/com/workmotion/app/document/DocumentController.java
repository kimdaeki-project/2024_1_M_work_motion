package com.workmotion.app.document;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/document/*")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@PostMapping("add")
	public void createDocument(DocumentDTO documentDTO,MultipartFile[] file,Model model,HttpSession session)throws Exception{
		
		
		
		
		
	}

}
