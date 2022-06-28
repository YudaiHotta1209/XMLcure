package com.example.demo.mapper.meeting.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.FullCalendar.DailySummary;
import com.example.demo.domain.Meeting.Meeting;

@Mapper
public interface UserMeetingMapper {
	
	//全件取得（ログインしたユーザーID（username)をもとに検索処理）
    List<Meeting> findAll(String username);
	
	//1件取得(詳細表示）
	Meeting selectOne(Long id);
	
	//登録処理
	void insert(Meeting meeting);
	
	//更新処理
	void update(Meeting meeting);
	
	//削除処理
	void delete(Long id);
	
	//カレンダー表示検索
	//全件検索処理
	List<DailySummary> findAllReserving(); 	
}
