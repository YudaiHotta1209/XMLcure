package com.example.demo.service.Meeting.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.FullCalendar.DailySummary;
import com.example.demo.domain.Meeting.Meeting;
import com.example.demo.mapper.meeting.user.UserMeetingMapper;

@Service
public class UserMeetingService {

	@Autowired
	private UserMeetingMapper userMeetingMapper;

	//①全件取得（ログインしたユーザーID（username)をもとに検索処理）
	@Transactional
	public List<Meeting> findAll(String username) {
		return userMeetingMapper.findAll(username);
	}

	//②一件取得
	@Transactional
	public Meeting selectOne(Long id) {
		return userMeetingMapper.selectOne(id);
	}

	//③登録
	@Transactional
	public void insert(Meeting meeting) {
		userMeetingMapper.insert(meeting);
	}

	//④更新
	@Transactional
	public void update(Meeting meeting) {
		userMeetingMapper.update(meeting);
	}

	//⑤削除処理
	@Transactional
	public void delete(Long id) {
		userMeetingMapper.delete(id);
	}

	//カレンダー予約情報表示
	//⑤全件検索処理
	@Transactional
	public List<DailySummary> findAllReserving() {
		return userMeetingMapper.findAllReserving();
	}
}
