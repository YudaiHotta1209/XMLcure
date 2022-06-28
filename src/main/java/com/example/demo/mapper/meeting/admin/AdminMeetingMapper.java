package com.example.demo.mapper.meeting.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Meeting.Meeting;

@Mapper
public interface AdminMeetingMapper {
	//全件表示
    List<Meeting> findAll();	
	//1件取得(詳細表示）
	Meeting selectOne(Long id);
	//登録処理
	void insert(Meeting meeting);
	//更新処理
	void update(Meeting meeting);
	//削除処理
	void delete(Long id);
	
///カラムが多いためどうパッケージ内のMeeting.xmlに条件・SQL文を記載
}
