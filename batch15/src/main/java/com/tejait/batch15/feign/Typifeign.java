package com.tejait.batch15.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name="TypiCode",
url = "https://jsonplaceholder.typicode.com/") // base url
public interface Typifeign {
				
				@GetMapping("comments")
				public List<Commentsdto> getComments(); // list of comments
			 
				@GetMapping("posts")
				public List<Postsdto> getPosts();
			}


