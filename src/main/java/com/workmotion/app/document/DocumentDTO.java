package com.workmotion.app.document;

import java.sql.Date;
import java.util.List;

import com.workmotion.app.department.DepartmentDTO;
import com.workmotion.app.document.file.DocumentFileDTO;
import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.templete.TempleteDTO;

public class DocumentDTO {
	
	private Long id;
	private String title;
	private String content;
	private Long templete_id;
	private Date create_dt;
	private Long member_id;	
	private String referrer;
	private Long temporary_save;
	private String period;
	private String phone;
	private Date deadline;
	private List<DocumentFileDTO> documentFileDTOs;

	
	private MemberDTO memberDTO;
	private DepartmentDTO departmentDTO;

	
	
	
	
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}
	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}
	
	

	
	public List<DocumentFileDTO> getDocumentFileDTOs() {
		return documentFileDTOs;
	}
	public void setDocumentFileDTOs(List<DocumentFileDTO> documentFileDTOs) {
		this.documentFileDTOs = documentFileDTOs;
	}
	public Long getTemporary_save() {
		return temporary_save;
	}
	public void setTemporary_save(Long temporary_save) {
		this.temporary_save = temporary_save;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getTemplete_id() {
		return templete_id;
	}
	public void setTemplete_id(Long templete_id) {
		this.templete_id = templete_id;
	}
	public Date getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(Date create_dt) {
		this.create_dt = create_dt;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
	
	
	
	
	
	
}