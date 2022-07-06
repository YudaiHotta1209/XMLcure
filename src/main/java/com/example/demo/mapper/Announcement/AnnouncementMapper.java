package com.example.demo.mapper.Announcement;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Announcement.Announcement;

@Mapper
public interface AnnouncementMapper {
	//全件取得
	@Select("select*from announcement")
    List<Announcement> findAll();
	
	//登録処理
	@Insert("insert into announcement(daypost,message) values(#{daypost}, #{message})")
	void insert(Announcement announcement);
	
	//削除処理
	@Delete("delete from announcement where id = #{id}")
	void delete(Long id);
}
