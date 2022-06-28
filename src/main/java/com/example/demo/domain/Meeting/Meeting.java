package com.example.demo.domain.Meeting;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Meeting {
	
	//ID
	private Long id;
		
	//集会室番号
	@NotBlank(message = "部屋番号を入力してください。")
	private String roomid;

	
	//ユーザー名
	@NotBlank(message = "ユーザーIDを入力してください。")
	private String username;

	
	//オーナー名
	@NotBlank(message = "利用者名を入力してください。")
	private String owner;
	
	//利用開始時間
	@NotBlank
	private String start;
	
	//利用終了時間
	@NotBlank
	private String end;
	
	//用途
	@NotBlank(message = "用途を選択してください。")
	private String title;
	
	//利用人数
	@Min(value = 1, message = "2以上の利用予定人数を入力してください。")
	@Max(value = 10, message = "8以下の利用予定人数を入力してください。")
	private Integer people;
	
	//備考欄
	@NotBlank(message = "要望事項がある場合は入力してください。")
	private String remarks;
	
	//承認状況
	private String admincomment;
}