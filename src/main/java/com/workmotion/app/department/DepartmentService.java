package com.workmotion.app.department;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.util.Pager;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDAO departmentDAO;
		
	//리스트 리스트 리스트@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public List<MemberDTO> getDepartmentList(Pager pager)throws Exception{
			pager.makeRow();
			
			Long totalCount = departmentDAO.getTotalCount(pager);
			pager.makePage(totalCount);
			
		return departmentDAO.getDepartmentList(pager);		
		}
	//디테일 디테일 디테일@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public List<MemberDTO> getDepartmentDetail(MemberDTO memberDTO) throws Exception{
		return departmentDAO.getDepartmentDetail(memberDTO);
		
	}
	
	public List<Map<String, Object>> getMemberList(Pager pager)throws Exception{
		pager.makeRow();
		return departmentDAO.getMemberList(pager);
	}
	
//	public int createDepartment(MemberDTO memberDTO) throws Exception{
//		return departmentDAO.createDepartment(memberDTO);
//	}
	
}
