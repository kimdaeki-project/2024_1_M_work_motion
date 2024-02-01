package com.workmotion.app.member;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;


	
	public MemberDTO getlogin(MemberDTO memberDTO) throws Exception {
		MemberDTO m = memberDAO.getMemberDetail(memberDTO);
		
		if(m!=null) {
			if(m.getPassword().equals(memberDTO.getPassword())) {
				//이메일이 맞고 비밀번호도 맞다

				return memberDTO;
			}else {
				//이메일은 맞고 비밀번호는 다르다
				 m = null;
			} 
		}else {
			m=null;
			
		}
		return m;
		
	}
	public int updateMember(MemberDTO memberDTO) throws Exception {
		return	memberDAO.updateMember(memberDTO);
	}
//	public int deleteMember(MemberDTO memberDTO) throws Exception {
//		return memberDAO.deleteMember(memberDTO);
//	}
	public int createMember(MemberDTO memberDTO) throws Exception {
		return memberDAO.createMember(memberDTO);
	}
}
