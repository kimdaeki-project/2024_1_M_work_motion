package com.workmotion.app.document;

import java.sql.Date;

import com.workmotion.app.document.util.MemberDTO;
import com.workmotion.app.templete.TempleteDTO;

public class DocumentDTO {
	
	private Long id;
	private String title;
	private String content;
	private Long templete_id;
	private Date create_dt;
	private Long member_id;
	private String document_nb;
	private String document_list;
	private String referrer;
	
	
	// dto 2개 getter setter 해야함
	private MemberDTO memberDTO;
	private TempleteDTO templeteDTO;
	
	
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
	public String getDocument_nb() {
		return document_nb;
	}
	public void setDocument_nb(String document_id) {
		this.document_nb = document_id;
	}


}
