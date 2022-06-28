package com.example.demo.controller.Fullcarendar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.FullCalendar.DailySummary;
import com.example.demo.service.Meeting.user.UserMeetingService;
import com.fasterxml.jackson.databind.ObjectMapper;

//－－－－－－－－－－－－－－－－－－メモ－－－－－－－－－－－－－－－－－－－－//

/*
 * 機能実装方法の手本 
 * （１）FullCalendar用のmodelを作成 
 * （２）DBから予約履歴を検索
 * （３）（２）を（１）で作成したmodelに格納
 * （４）（２）のデータ（model）をRestControllerに渡す。
 * （５）予約情報の文字列にリンクタグを埋め込む。 
 * （６）データをJson化し、FullCalendarに渡す。 
 * （７）FullCalendarに表示
 */
//－－－－－－－－－－－－－－－－－－メモ－－－－－－－－－－－－－－－－－－－－//
@Controller
@RestController
@RequestMapping("/Calendar")
public class RestCalenderController {

	@Autowired
	UserMeetingService userMeetingService;

	@GetMapping(value = "/Reserving")
	public String getReserving() {
		String jsonMsg = null;
		try {
			List<DailySummary> reservings = new ArrayList<DailySummary>();
			List<DailySummary> dailySummaries = userMeetingService.findAllReserving();
			for (int i = 0; i < dailySummaries.size(); i++) {
				DailySummary dailySummary = new DailySummary();
				dailySummary = dailySummaries.get(i);
				reservings.add(dailySummary);
			}
			ObjectMapper mapper = new ObjectMapper();
			jsonMsg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(reservings);

		} catch (IOException ioex) {
		}
		return jsonMsg;
	}

}