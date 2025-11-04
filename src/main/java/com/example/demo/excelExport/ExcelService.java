//package com.example.demo.excelExport;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.ListOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ExcelService {
//	
//	@Autowired
//	private RedisTemplate redisTemplate;
//	
//	
//	private ListOperations<String,Object> listOps;
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<String> addIntoRedis(){
//		
//		Map<String,String> map=new HashMap<>();
//		map.put("Username","Balasubramaniyan");
//		map.put("password","RajaRaja ");
//		redisTemplate.opsForHash().putAll("Map", map);
//		Map<Object, Object> redisMap = redisTemplate.opsForHash().entries("Map");
//		listOps.rightPush("Map", map);
//		
//		   return ResponseEntity.ok("Successfully Added: " + listOps.leftPop("Map"));
//	}
//
//}
