package com.example.demo.controller.user.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Register.UserForm;
import com.example.demo.service.Login.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	
	//－－－－－－－－－－－－－－－－－－画面遷移－－－－－－－－－－－－－－－－－－－－//
	//①ユーザー一覧画面遷移
	@GetMapping
	public String showList(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "Admin/users/list";
	}
	
    //②User詳細情報登録画面遷移
	@GetMapping("/UserCreate") 
	public String showCreationForm(@ModelAttribute UserForm Form) { 
	  return "Admin/users/creationForm";
	  }
	
	//－－－－－－－－－－－－－－－－－－ユーザー（ID/PASSWORD/Authority)のCRUD処理－－－－－－－－－－－－－－－－－－－－//
	
    //①ユーザーID・パスワード・権限登録処理
	@PostMapping 
	public String create(@Validated UserForm form, BindingResult bindingResult) {
	  if (bindingResult.hasErrors()) { 
		  return showCreationForm(form);
		  } userService.create(form.getUsername(), form.getPassword(), form.getAuthority());
		  return "redirect:/users"; 
	  }
	
  }
