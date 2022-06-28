package com.example.demo.controller.meeting.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Meeting.Meeting;
import com.example.demo.service.Meeting.admin.AdminMeetingService;


@Controller
@RequestMapping("/meetings/admin")

//－－－－－－－－－－－－－－－－－－メモ－－－－－－－－－－－－－－－－－－ーーー
/*
 * <--管理者側から行う操作--> 
 * ①ユーザーが登録した予約情報を全件取得する 
 * 
 * <--既存機能の活用--> 
 * ①詳細表示 ②削除処理 ③変更処理
 */

//－－－－－－－－－－－－－－－－－－メモ－－－－－－－－－－－－－－－－－－－－－//

public class AdminMeetingController {

	@Autowired
	private AdminMeetingService adminMeetingService;
		
//－－－－－－－－－－－－－－－－－－画面遷移－－－－－－－－－－－－－－－－－－－－－//	
	//①全ユーザー予約リスト表示
	@GetMapping
	public String list(Model model) {
		model.addAttribute("meeting_info", adminMeetingService.findAll());
		return "Admin/request/m-RequestList";
	}
	
    //②新規登録ページ表示
	@GetMapping("/RequestNew")
	public String newMeeting(@ModelAttribute("meeting_info") Meeting meeting, Model model) {
		return "Admin/request/m-RequestNew";
	}

//－－－－－－－－－－－－－－－－－－画面遷移－－－－－－－－－－－－－－－－－－－－－//	
	

	
//－－－－－－－－－－－－－－－－－－CRUD処理－－－－－－－－－－－－－－－－－－－－//

	
	//①登録処理（データ登録）
	@PostMapping
	public String create(@ModelAttribute("meeting_info") @Validated Meeting meeting, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Admin/request/m-RequestNew";
		} else {
			adminMeetingService.insert(meeting);
			return "redirect:/meetings/admin";
		}
	}
	
	
	//②詳細表示（画面遷移）
	@GetMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("meeting_info", adminMeetingService.selectOne(id));
		return "Admin/request/m-RequestShow";
	}



    //③編集処理（画面遷移）
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable Long id, @ModelAttribute("meeting_info") Meeting meeting, Model model) {
		model.addAttribute("meeting_info", adminMeetingService.selectOne(id));
		return "Admin/request/m-RequestEdit";
	}
	

	
    //④更新処理（データ更新）
	@PutMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute("meeting_info") @Validated Meeting meeting, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("meeting_info", meeting);
			return "Admin/request/m-RequestEdit";
		} else {
			meeting.setId(id);
			adminMeetingService.update(meeting);
			return "redirect:/meetings/admin";
		}
	}
	
	//⑤削除処理
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		adminMeetingService.delete(id);
		return "redirect:/meetings/admin"; 
	}
//－－－－－－－－－－－－－－－－－－CRUD処理－－－－－－－－－－－－－－－－－－－－//
}