package com.example.demo.Jasper;

import java.util.List;

public class SampleReport {
	
	private String name;
	private String College;
	private String Mobile;
	private String address;
	private String Team;
	private String Company;
	
	private List<nestedList> sampleList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTeam() {
		return Team;
	}
	public void setTeam(String team) {
		Team = team;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public List<nestedList> getSampleList() {
		return sampleList;
	}
	public void setSampleList(List<nestedList> sampleList) {
		this.sampleList = sampleList;
	}
	
	

}
