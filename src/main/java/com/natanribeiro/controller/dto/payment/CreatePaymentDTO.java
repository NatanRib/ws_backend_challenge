package com.natanribeiro.controller.dto.payment;

import com.natanribeiro.data.entity.Payment;

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
    	return new Payment(null, mode, null, installments, null);
    }
}
