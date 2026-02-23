package com.tejait.batch15.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("fileupload")
public class FileController {

	  private static final String uploadDir = "D:\\";
	  
	    @PostMapping("/upload")
	    public String fileUpload(@RequestParam("file") MultipartFile file) {
	        try {
	            File directory = new File(uploadDir);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }
	 
	            String filePath = uploadDir + file.getOriginalFilename();
	            file.transferTo(new File(filePath));
	 
	            return "File uploaded successfully: " + file.getOriginalFilename();
	        } catch (IOException e) {
	            return "File upload failed: " + e.getMessage();
	        }
	    }
	    
	    @GetMapping("/download/{filename}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
	        try {
	            Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
	            Resource resource = new UrlResource(filePath.toUri());
	 
	            if (resource.exists()) {
	                return ResponseEntity.ok()
	                        .header(HttpHeaders.CONTENT_DISPOSITION,
	                                "attachment; filename=\"" + resource.getFilename() + "\"")
	                        .body(resource);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (MalformedURLException e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }
	}
	 
	
	
	

