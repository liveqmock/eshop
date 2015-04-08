package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

import net.shangtech.framework.web.controller.validation.constraints.Mobile;

import org.hibernate.validator.constraints.NotBlank;

public class MemberAddressCommand implements Serializable {

    private static final long serialVersionUID = 3125931256520353319L;
	
    private Long id;
    
    @NotBlank
    private String contact;
    
    private String country;
    
    @NotBlank
    private String province;
    
    @NotBlank
    private String city;
    
    @NotBlank
    private String district;
    
    @NotBlank
    private String street;
    
    @NotBlank
    @Mobile
    private String mobile;
    
    @NotBlank
    private String postcode;
    
    private Boolean isDefault = false;

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
    
}
