package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 */
@Entity
public class Details {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;

	private String name;
	
	private String details;
	private String Email;
	private String techKnown;
	private String version;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTechKnown() {
		return techKnown;
	}
	public void setTechKnown(String techKnown) {
		this.techKnown = techKnown;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Details(Long id, String name, String details, String email, String techKnown, String version) {
		super();
		Id = id;
		this.name = name;
		this.details = details;
		Email = email;
		this.techKnown = techKnown;
		this.version = version;
	}
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Details [Id=" + Id + ", name=" + name + ", details=" + details + ", Email=" + Email + ", techKnown="
				+ techKnown + ", version=" + version + "]";
	}
	
	
	
	
	
}
