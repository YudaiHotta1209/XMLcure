package com.example.demo.domain.Register;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.validation.UniqueUsername;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {

	/* ログイン用（ID/PASSWORD/AUTHORITY) */
	@NotBlank
	@UniqueUsername
	private String username;

	@NotBlank
	@Size(min = 12, max = 128)
	private String password;

	@NotBlank
	private String authority;

}