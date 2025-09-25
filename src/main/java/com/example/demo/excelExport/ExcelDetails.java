package com.example.demo.excelExport;


public class ExcelDetails {
	
	private int id;
	
	private String name;
	private String college;
	private String company;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public ExcelDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExcelDetails(int id, String name, String college, String company) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.company = company;
	}
	@Override
	public String toString() {
		return "ExcelDetails [id=" + id + ", name=" + name + ", college=" + college + ", company=" + company + "]";
	}

	
	
}
