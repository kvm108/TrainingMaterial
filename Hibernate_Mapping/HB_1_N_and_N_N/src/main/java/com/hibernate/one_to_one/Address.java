package com.hibernate.one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	
	@Id
	@Column(name = "ADDRESS_ID")
	private long addressId;
	
	@Column(name = "STREET") 
	private String street;
	
	@Column(name = "CITY") 
	private String city;
	
	Address() {}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + "]";
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(long addressId, String street, String city) {
		this.addressId = addressId;
		this.street = street;
		this.city = city;
	}
}
