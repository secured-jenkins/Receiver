package com.example.DTO;

import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String address;
	private String password;

	public EmployeeDTO() {

	}

	public EmployeeDTO(String firstName, String lastName, String address, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
