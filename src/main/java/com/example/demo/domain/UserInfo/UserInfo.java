package com.example.demo.domain.UserInfo;


import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserInfo {	
	//ID
	private Long id;

	//username
	@NotBlank(message = "usernameを入力してください。")
	private String username;
	
	//username
	@NotBlank(message = "区分所有者名を入力してください。")
	private String owner;
	
	//勤務先
	@NotBlank(message = "勤務先会社名を入力してください。")
	private String address;

	
	//オーナー名
	@NotBlank(message = "勤務先の住所を入力してください。")
	private String workspace;
	
	//利用開始時間
	@NotBlank(message = "メールアドレスを入力してください。")
	private String mailaddress;
	
	//連絡先
	@NotBlank(message = "連絡先（電話番号）を選択してください。")
	private String phone;
	
	//備考欄
	private String information;
	
}