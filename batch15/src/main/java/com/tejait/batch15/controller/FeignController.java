package com.tejait.batch15.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.feign.Commentsdto;
import com.tejait.batch15.feign.Postsdto;
import com.tejait.batch15.feign.Typifeign;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("feign")
public class FeignController {
Typifeign typiFeign;
	
	@GetMapping("getComments")
	public ResponseEntity<List<Commentsdto>> getComments(){
	List<Commentsdto> comments	=typiFeign.getComments();
	return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	
	@GetMapping("getPosts")
	public ResponseEntity<List<Postsdto>> getPosts(){
	  List<Postsdto> posts =typiFeign.getPosts();
	  return new ResponseEntity<>(posts, HttpStatus.OK);
	}
 
}


