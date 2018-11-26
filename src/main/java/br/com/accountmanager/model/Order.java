package br.com.accountmanager.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.accountmanager.enums.PaymentOption;

/**
 * @author Lucas
 *
 */
public class Order implements Serializable {
	
	private static final long serialVersionUID = 4670974702962672549L;

	private Integer idOrder;

	@NotBlank(message=" can't be empty.")
	@Max(value=150, message="Address can't has more than 150 characters.")
	private String address;
	
	@NotNull(message="Number can't be null.")
	@Size(min=0, max=100000, message="Number can't has more than 100000 numbers.")
	private Integer number;
	
	@Max(value=150, message="Optional Address can't has more than 150 characters.")
	private String optionalAddress;
	
	@NotNull(message="Payment Option can't be null.")
	private PaymentOption paymentOption;
	
	
	private List<OrderItems> listOrderItems;
	
	public Integer getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getOptionalAddress() {
		return optionalAddress;
	}
	public void setOptionalAddress(String optionalAddress) {
		this.optionalAddress = optionalAddress;
	}
	public PaymentOption getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(PaymentOption paymentOption) {
		this.paymentOption = paymentOption;
	}
	public List<OrderItems> getListOrderItems() {
		return listOrderItems;
	}
	public void setListOrderItems(List<OrderItems> listOrderItems) {
		this.listOrderItems = listOrderItems;
	}
	
}
