package com.workmotion.app.templete;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.workmotion.app.document.util.FileManager;
import com.workmotion.app.document.util.Pager;

@Service
public class TempleteService {
	
	@Autowired
	private TempleteDAO templeteDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	public List<TempleteDTO> getTempleteList(Pager pager)throws Exception{
		
		pager.makeRow();
		Long totalCount = templeteDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		List<TempleteDTO> ar = templeteDAO.getTempleteList(pager);
		
		return ar;
		
	}
	
	
	
	
	public int createTempleteAdd(TempleteDTO templeteDTO,MultipartFile templeteFile)throws Exception{
		
		if(templeteFile.isEmpty()) {
			return 0;
		}
				
		String path = servletContext.getRealPath("/resources/upload/templete");
		
		System.out.println(path);
		
		String fileName = fileManager.fileSave(path, templeteFile);
		
		templeteDTO.setName(fileName);
		templeteDTO.setFile_nm(templeteFile.getOriginalFilename());
		
		int result = templeteDAO.createTempleteAdd(templeteDTO);
		
		
		return result;
		
	} 

}
