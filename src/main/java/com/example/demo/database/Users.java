package com.example.demo.database;

public class Users {

	    private Long id;
	    private String name;
	    private String email;
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public Users() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Users(Long id, String name, String email) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
		}
		@Override
		public String toString() {
			return "Users [id=" + id + ", name=" + name + ", email=" + email + "]";
		}
		
	    
	    
	    
}
