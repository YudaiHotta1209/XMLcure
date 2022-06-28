package com.example.demo.service.Meeting.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Meeting.Meeting;
import com.example.demo.mapper.meeting.admin.AdminMeetingMapper;

@Service
public class AdminMeetingService {

	@Autowired
	private AdminMeetingMapper adminMeetingMapper;

	// 全件取得

	@Transactional
	public List<Meeting> findAll() {
		return adminMeetingMapper.findAll();
	}

	// 一件取得
	@Transactional
	public Meeting selectOne(Long id) {
		return adminMeetingMapper.selectOne(id);
	}

	// 登録
	@Transactional
	public void insert(Meeting meeting) {
		adminMeetingMapper.insert(meeting);
	}

	// 更新
	@Transactional
	public void update(Meeting meeting) {
		adminMeetingMapper.update(meeting);
	}

	@Transactional
	public void delete(Long id) {
		adminMeetingMapper.delete(id);
	}

}
