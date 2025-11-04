package com.example.demo.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService ser;
	
	@PostMapping("/user/create")
	public ResponseEntity<String> createUsers(@RequestBody Users user){
		
		
		
		int size =120;
		
		
		int list1=ser.createUser(user);
		
		if(list1!=0) {
			return ResponseEntity.ok("SuccessFully created");
		}
		
		
		
		
		
		
		
		else if(0!= 0) {
			return ResponseEntity.ok("SuccessFully created conflict");
		}
		
		
		
		
		
		else {
			return ResponseEntity.ok("Users Not created");
		}
		
	}

}
