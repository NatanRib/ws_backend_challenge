package com.natanribeiro.framework.form.sales_order;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.natanribeiro.domain.entities.sales_order.Payment;

public class CreateSalesOrderPaymentForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "payment.mode cannot be blank")
	private String mode;
    private Integer installments;
    
    public CreateSalesOrderPaymentForm() {}

	public CreateSalesOrderPaymentForm(String mode, Integer installments) {
		super();
		this.mode = mode;
		if (installments == null) {
			this.installments = 1;
		}else {			
			this.installments = installments;
		}
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
