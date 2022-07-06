package com.example.demo.mapper.meeting.admin;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Meeting.Meeting;

@Mapper
public interface AdminMeetingMapper {
	//全件表示
	@Select("select*from meeting_info")
    List<Meeting> findAll();	
	//1件取得(詳細表示）
	@Select("select*from meeting_info where id= #{id}")
	Meeting selectOne(Long id);
	//登録処理
	@Insert("insert into meeting_info(roomid,username,people,owner,title,start,end,remarks,admincomment) values(#{roomid}, #{username}, #{people},#{owner},#{title},#{start},#{end},#{remarks},#{admincomment})")
	void insert(Meeting meeting);
	//更新処理
	@Update("update meeting_info set roomid=#{roomid}, username=#{username}, start=#{start},end=#{end},people=#{people}, owner=#{owner}, title=#{title},remarks=#{remarks},admincomment=#{admincomment} where id= #{id}")
	void update(Meeting meeting);
	//削除処理
	@Delete("delete from meeting_info where id = #{id}")
	void delete(Long id);
	
///カラムが多いためどうパッケージ内のMeeting.xmlに条件・SQL文を記載
}
