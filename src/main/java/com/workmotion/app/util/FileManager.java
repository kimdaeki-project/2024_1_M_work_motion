package com.workmotion.app.util;

import java.io.File;
import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	
	public String fileSave(String path, MultipartFile file) throws Exception {
		File f = new File(path);
		if(f.exists()) {
			
		}else {
			f.mkdir();
		}
		Calendar ca = Calendar.getInstance();
		String fileName = ca.getTimeInMillis() + "_" + file.getOriginalFilename();
		f = new File(f,fileName);
		file.transferTo(f);
		return fileName;		
	}

	public int fileDelete(String path,String fileName) throws Exception {
		int result=0;
		File f =  new File(path);
		if(f.isFile()) {
			f = new File(path,fileName);
			f.delete();
			result=1;
		}else {
			
		}
		return result;
	}
}
