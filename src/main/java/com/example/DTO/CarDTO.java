package com.example.DTO;

public class CarDTO {
	private Long id;
	private String model;

	public CarDTO() {
		
	}
	
	public CarDTO(Long id, String model) {
		super();
		this.id = id;
		this.model = model;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
