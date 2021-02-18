package com.addressbook.main;

public class Address {
	private String street;
	private String city;
	private String country;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	 public boolean equals(Address addr) {
		    if(street.equals(this.street) && city.equals(this.city)
		          && country.equals(this.country))
		      return true;
		    return false;
		  }

}
