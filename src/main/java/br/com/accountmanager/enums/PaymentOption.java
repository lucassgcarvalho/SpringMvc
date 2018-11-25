package br.com.accountmanager.enums;

public enum PaymentOption {
	CRED("Cred"), DEBIT("Debit");
	
	private String paymentOption;

	PaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
}
