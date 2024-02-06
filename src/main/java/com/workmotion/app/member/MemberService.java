package com.workmotion.app.member;







import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.workmotion.app.util.FileManager;



@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ServletContext servletContext;

	
	public MemberDTO getlogin(MemberDTO memberDTO) throws Exception {
		MemberDTO m = memberDAO.detailMember(memberDTO);
			return m;
		
	}
	
	public int setFileAdd (MemberDTO memberDTO,MultipartFile picture) throws Exception {
		String path = servletContext.getRealPath("resources/upload/member");
		String fileName = fileManager.fileSave(path, picture);
		Avatar avatar = new Avatar();
		avatar.setMember_id(memberDTO.getId());
		avatar.setName(fileName);
		avatar.setOri_name(picture.getOriginalFilename());
		return memberDAO.setFileAdd(avatar);
	}
	public void setFileDelete (MemberDTO memberDTO) throws Exception {
		MemberDTO m = memberDAO.detailMember(memberDTO);
		String path = servletContext.getRealPath("resources/upload/member");
			if(m.getAvatar().getName()!=null) {
			fileManager.fileDelete(path, m.getAvatar().getName());			
			memberDAO.setFileDelete(m.getAvatar());
		}

	}
	 
	public int updateMember(MemberDTO memberDTO) throws Exception {
		return	memberDAO.updateMember(memberDTO);
	}
	public MemberDTO detailMember (MemberDTO memberDTO) throws Exception {
		return memberDAO.detailMember(memberDTO);
	}
	public MemberDTO emailCheck(MemberDTO memberDTO) throws Exception {
		return memberDAO.emailCheck(memberDTO);
	}

	public int getjoin(MemberDTO memberDTO) throws Exception {
		return memberDAO.createMember(memberDTO);
	}
}
