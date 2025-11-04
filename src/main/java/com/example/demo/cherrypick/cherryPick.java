package com.example.demo.cherrypick;

import jakarta.persistence.Entity;

@Entity
public class cherryPick {
	
	private String Name;
	private String College;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	
	

}
