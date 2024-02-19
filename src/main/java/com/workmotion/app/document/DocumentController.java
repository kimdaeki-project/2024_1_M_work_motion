package com.workmotion.app.document;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.referrer.ReferrerDTO;

@Controller
@RequestMapping("/document/*")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("add")
	public void createDocument()throws Exception{
		
	}
	
	@PostMapping("add")
	public String createDocument(DocumentDTO documentDTO,MultipartFile[] file,Model model,String referrer,HttpSession session)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");		
				
		documentDTO.setMember_id(memberDTO.getId());				
		
		int result = documentService.createDocument(documentDTO, file,referrer);
		
		String msg = "등록 실패";
		
		if(result>0) {
			if(documentDTO.getTemporary_save()==1) {
				msg = "임시저장했습니다.";
				
			}else if(documentDTO.getTemporary_save()==0) {
				msg = "등록 성공";
				
			}
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "../docTemplete/list");
						
		return "commons/result";		
		
	}
	
	@GetMapping("list")
	public String getDocumentList()throws Exception{
		
		return "";
	}
	

}
