package com.example.demo.domain.FullCalendar;

import lombok.Data;

/**
 * FullCalendar用Event Object
 * 
 * @see https://fullcalendar.io/docs/event_data/Event_Object/
 */
@Data
public class DailySummary {

	/*
	 * カレンダーに表示する内容
	 */
	
	/* 用途 */
	private String title;

	/* 使用日 */
	private String start;

	
	/* 使用開始時間 */ 
	private String end;
}