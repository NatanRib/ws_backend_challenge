package com.natanribeiro.appservice.dto.sales_order;

import java.io.Serializable;

import com.natanribeiro.domain.entities.sales_order.Payment;

public class GetSalesOrderPaymentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String mode;
    private Double amount;
    private Integer installments;
    private Double installmentValue;
	
    public GetSalesOrderPaymentDTO(String mode, Double amount, Integer installments, Double installmentValue) {
		super();
		this.mode = mode;
		this.amount = amount;
		this.installments = installments;
		this.installmentValue = installmentValue;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public Double getInstallmentValue() {
		return installmentValue;
	}

	public void setInstallmentValue(Double installmentValue) {
		this.installmentValue = installmentValue;
	}
    
	public static GetSalesOrderPaymentDTO fromPayment(Payment payment) {
		return new GetSalesOrderPaymentDTO(payment.getMode(),
				payment.getAmount(), payment.getInstallments(),
				payment.getInstallmentValue());
	}
}
