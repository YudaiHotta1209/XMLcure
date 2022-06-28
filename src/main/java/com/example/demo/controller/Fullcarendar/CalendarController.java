package com.example.demo.controller.Fullcarendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalendarController {
		
    ///①カレンダー画面遷移
	@RequestMapping(path = "/Schedule", method = RequestMethod.GET)
    String getCalendar(Model model) {
        return "FC/CommonCalendar";
    }
}