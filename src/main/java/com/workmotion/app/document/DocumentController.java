package com.workmotion.app.document;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.workmotion.app.approval.ApprovalDTO;
import com.workmotion.app.document.util.Pager;
import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.referrer.ReferrerDTO;

@Controller
@RequestMapping("/document/*")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("detail")
	public String getDetail(DocumentDTO documentDTO,Model model)throws Exception{
		documentDTO = documentService.getDetail(documentDTO);		
		model.addAttribute("dto",documentDTO);
		
		System.out.println(documentDTO.getMemberDTO().getName());
		model.addAttribute("page", "document/detail");	
		
		System.out.println(documentDTO.getReferrerDTOs());
		
		
		return "index";
		
	}
	
	@GetMapping("list")
	public String getDocumentList(HttpSession session,Model model,Pager pager)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		pager.setMember_id(memberDTO.getId());
		
		
		List<DocumentDTO> ar =  documentService.getDocumentList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		model.addAttribute("page", "document/list");
		
		return "index";
	}	
	
	@GetMapping("add")
	public void createDocument()throws Exception{
		
	}
	//서류 추가
	@PostMapping("add")
	public String createDocument(DocumentDTO documentDTO,MultipartFile[] file,Model model,String referrer,HttpSession session,String approval)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");		
				
		documentDTO.setMember_id(memberDTO.getId());				
		
		int result = documentService.createDocument(documentDTO, file,referrer,approval);
		
		String msg = "등록 실패";
		
		if(result>0) {
			if(documentDTO.getTemporary_save()==1) { // 1이면 임시저장
				msg = "임시저장했습니다.";
				
			}else if(documentDTO.getTemporary_save()==0) { //0이면 보내기 
				msg = "등록 성공";
				
			}
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "../docTemplete/list");
						
		return "commons/result";		
		
	}	

	

}
