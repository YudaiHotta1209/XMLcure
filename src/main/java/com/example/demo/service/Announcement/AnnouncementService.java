package com.example.demo.service.Announcement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Announcement.Announcement;
import com.example.demo.mapper.Announcement.AnnouncementMapper;

@Service
public class AnnouncementService {

	@Autowired
	private AnnouncementMapper announcemenMapper;

	//①全件取得
	@Transactional
	public List<Announcement> findAll() {
		return announcemenMapper.findAll();
	}

	//②登録
	@Transactional
	public void insert(Announcement announcement) {
		announcemenMapper.insert(announcement);
	}
    //③削除
	@Transactional
	public void delete(Long id) {
		announcemenMapper.delete(id);
	}

}
