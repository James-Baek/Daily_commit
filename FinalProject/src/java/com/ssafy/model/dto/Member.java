package com.ssafy.model.dto;

import java.io.Serializable;

public class Member implements Serializable {
	private String id        ;
	private String password  ;
	private String name      ;
	private String email     ;
	private String phone     ;
	private String address   ;
	private String material  ;
	private String gender;
	private String birthdate;
	
	public Member() {}
	public Member(String id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	
	public Member(String id, String password, String name, String email, String phone, String address, String material,
			String gender, String birthdate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.material = material;
		this.gender = gender;
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [id=").append(id).append(", password=").append(password).append(", name=").append(name)
				.append(", email=").append(email).append(", phone=").append(phone).append(", address=").append(address)
				.append(", material=").append(material).append(", birthdate=").append(birthdate).append(", gender=").append(gender).append("]");
		return builder.toString();
	}
	
}
