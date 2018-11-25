package br.com.accountmanager.model;

import java.io.Serializable;
import java.util.List;

import br.com.accountmanager.enums.PaymentOption;

/**
 * @author Lucas
 *
 */
public class Order implements Serializable {
	
	private static final long serialVersionUID = 4670974702962672549L;

	private Integer idOrder;
	private String address;
	private Integer number;
	private String optionalAddress;
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
