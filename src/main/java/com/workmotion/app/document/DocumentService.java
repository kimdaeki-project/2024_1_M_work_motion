package com.workmotion.app.document;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.workmotion.app.document.file.DocumentFileDTO;
import com.workmotion.app.document.util.FileManager;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentDAO documentDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ServletContext servletContext;
	
	public int createDocument(DocumentDTO documentDTO,MultipartFile[] file)throws Exception{
		
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
		
		
		return result;
	} 
	

	

}
