package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailsController {

	@Autowired
	DetailsRepo repo;
	
	@PostMapping("/create")
	public ResponseEntity<Details> createDetails(@RequestBody Details details){
		repo.save(details);
		
		return ResponseEntity.ok(details);
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<Details>> getDetails(){
		
		List<Details> detail = repo.findAll();
		
		return ResponseEntity.ok(detail);
	}
}
