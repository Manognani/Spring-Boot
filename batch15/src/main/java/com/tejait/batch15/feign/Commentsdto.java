package com.tejait.batch15.feign;

import lombok.Data;

@Data
public class Commentsdto {
	private int postId;
	private int ud;
	private String name;
	private String email;
	private String body;

}
