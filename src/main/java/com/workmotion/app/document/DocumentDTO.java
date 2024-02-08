package com.workmotion.app.document;

import java.sql.Date;

import com.workmotion.app.department.DepartmentDTO;
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
	private Long save;
	private String period;
	private String phone;
	private Date deadline;
	private String member_name;
	private String department_name;
	
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
	
	
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
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
	public Long getSave() {
		return save;
	}
	public void setSave(Long save) {
		this.save = save;
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