package com.workmotion.app.document;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.workmotion.app.document.file.DocumentFileDTO;
import com.workmotion.app.document.util.FileManager;
import com.workmotion.app.referrer.ReferrerDTO;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentDAO documentDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ServletContext servletContext;
	
	public int createDocument(DocumentDTO documentDTO,MultipartFile[] file,ReferrerDTO[] referrerDTO)throws Exception{
		
		int result = documentDAO.createDocument(documentDTO);
		
		String path = servletContext.getRealPath("/resources/upload/documentFiles");
		
		for(MultipartFile f:file) {
			
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
			DocumentFileDTO fileDTO = new DocumentFileDTO();
			fileDTO.setName(fileName);
			fileDTO.setOri_name(f.getOriginalFilename());
			fileDTO.setDocument_id(documentDTO.getId());
			result = documentDAO.createFiles(fileDTO);
		}
		
		
			for(ReferrerDTO r:referrerDTO) {
				
				ReferrerDTO dto = new ReferrerDTO();
				dto.setDocumet_id(documentDTO.getId());
				dto.setMember_id(documentDTO.getMember_id());
				result = documentDAO.createReferrer(r);
			}
		
		
		return result;
	} 
	

	

}
