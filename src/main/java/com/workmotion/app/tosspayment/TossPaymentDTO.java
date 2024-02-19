package com.workmotion.app.tosspayment;

import java.util.Date;

public class TossPaymentDTO {
	private Long id;
	private String orderId;
	private String amount;
	private String paymentKey;
	private Long member_id;
	private String create_dt;
	private Long period;

	


	public String getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPaymentKey() {
		return paymentKey;
	}

	public void setPaymentKey(String paymentKey) {
		this.paymentKey = paymentKey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMember_id() {
		return member_id;
	}

	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}

	public Long getPeriod() {
		return period;
	}

	public void setPeriod(Long period) {
		this.period = period;
	}
	
}
