package com.example.demo.domain.Announcement;


import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Announcement {

	
	//ID
	private Long id;
	
	//日時
	@NotBlank
	private String daypost;

	//コメント内容
	@NotBlank
	private String message;
	

}