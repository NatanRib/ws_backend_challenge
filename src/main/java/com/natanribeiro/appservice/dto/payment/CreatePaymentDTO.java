package com.natanribeiro.appservice.dto.payment;

import com.natanribeiro.domain.entities.sales_order.Payment;

public class CreatePaymentDTO {
	
	private String mode;
    private Integer installments;
    
    public CreatePaymentDTO() {}

	public CreatePaymentDTO(String mode, Integer installments) {
		super();
		this.mode = mode;
		this.installments = installments;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
    
    public Payment toPayment() {
    	Payment p = new Payment();
    	p.setMode(mode);
    	p.setInstallments(installments);
    	return p;
    }
}
