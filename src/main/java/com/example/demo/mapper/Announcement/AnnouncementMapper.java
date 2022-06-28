package com.example.demo.mapper.Announcement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Announcement.Announcement;

@Mapper
public interface AnnouncementMapper {
	//全件取得
    List<Announcement> findAll();
	
	//登録処理
	void insert(Announcement announcement);
	
	//削除処理
	void delete(Long id);
}
