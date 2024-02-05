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
	
	public List<Map<String, Object>> getMemberList(Map<String, Object> map)throws Exception{
		Pager pager = (Pager)map.get("pager");
		pager.makeRow();
		return departmentDAO.getMemberList(map);
	}
	
	public int createMember(MemberDTO memberDTO) throws Exception{
		return departmentDAO.createMember(memberDTO);
	}
	
	public int deleteMember(MemberDTO memberDTO)throws Exception{
		return departmentDAO.deleteMember(memberDTO);
	}
	
	public int createDepartment(DepartmentDTO departmentDTO) throws Exception{
		return departmentDAO.createDepartment(departmentDTO);
	}
	
	public int updateDepartment(DepartmentDTO departmentDTO)throws Exception{
		return departmentDAO.updateDepartment(departmentDTO);
	}
	
	public int deleteDepartment(DepartmentDTO departmentDTO) throws Exception{
		return departmentDAO.deleteDepartment(departmentDTO);
	}
	
}
