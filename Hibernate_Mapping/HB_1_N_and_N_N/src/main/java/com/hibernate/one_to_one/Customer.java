package com.hibernate.one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@Column(name="CUS_ID")
	private long cusId;
	
	@Column(name="CUS_NAME")
	private String cusName;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="addressId")
	private Address cusAddress;
	
	Customer() {}
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + "]";
	}
	public Address getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(Address cusAddress) {
		this.cusAddress = cusAddress;
	}
	public long getCusId() {
		return cusId;
	}
	public void setCusId(long cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public Customer(long cusId, String cusName, Address cusAddress) {
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusAddress = cusAddress;
	}
}
