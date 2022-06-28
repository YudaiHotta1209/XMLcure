package com.example.demo.controller.meeting.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

import com.example.demo.domain.Login.CustomUserDetails;
import com.example.demo.domain.Meeting.Meeting;
import com.example.demo.service.Meeting.user.UserMeetingService;

@Controller
@RequestMapping("/meetings")
public class UserMeetingController {

	@Autowired
	private UserMeetingService userMeetingService;

//－－－－－－－－－－－－－－－－－－検索処理（履歴一覧表示）－－－－－－－－－－－－－－－－－－－－//

	/*
	 * ①ログイン画面からCustomUserDetailsにusername/passwordを渡す
	 * ②CustomUserDetailsからusernameを取得 
	 * ③取得したusernameをもとに検索処理
	 * ④mapperクラスでModelに渡した変数で検索をかける ⑤結果を"meetings/Requestlist"に返す
	 */

	@GetMapping("/RequestList")
	public String list(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
		List<Meeting> meeting = userMeetingService.findAll(customUserDetails.getUsername());
		model.addAttribute("meeting_info", meeting);
		return "meetings/u-RequestList";
	}

//－－－－－－－－－－－－－－－－－－検索処理（履歴一覧表示）－－－－－－－－－－－－－－－－－－－－//

//－－－－－－－－－－－－－－－－－－画面遷移－－－－－－－－－－－－－－－－－－－－//
	// ①新規登録画面表示
	@GetMapping("new")
	public String newMeeting(@ModelAttribute("meeting_info") Meeting meeting, Model model) {
		return "meetings/u-RequestNew";
	}

	// ②詳細画面遷移
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("meeting_info", userMeetingService.selectOne(id));
		return "meetings/u-RequestShow";
	}

	// ③編集画面遷移
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, @ModelAttribute("meeting_info") Meeting meeting, Model model) {
		model.addAttribute("meeting_info", userMeetingService.selectOne(id));
		return "meetings/u-RequestEdit";
	}

//－－－－－－－－－－－－－－－－－－画面遷移－－－－－－－－－－－－－－－－－－－－//

//－－－－－－－－－－－－－－－－－－CRUD処理－－－－－－－－－－－－－－－－－－－－//	

	/// ①更新処理
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute("meeting_info") @Validated Meeting meeting,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("meeting_info", meeting);
			return "meetings/u-RequestEdit";
		} else {
			meeting.setId(id);
			userMeetingService.update(meeting);
			return "redirect:/meetings/RequestList";
		}
	}

	/// ②登録処理
	@PostMapping
	public String create(@ModelAttribute("meeting_info") @Validated Meeting meeting, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "meetings/u-RequestNew";
		} else {
			userMeetingService.insert(meeting);
			return "redirect:/meetings/RequestList";
		}
	}

	//③削除処理
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		userMeetingService.delete(id);
		return "redirect:/meetings/u-RequestList";
	}

//－－－－－－－－－－－－－－－－－－CRUD処理－－－－－－－－－－－－－－－－－－－－//	
}