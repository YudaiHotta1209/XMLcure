package com.example.demo.mapper.meeting.user;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.FullCalendar.DailySummary;
import com.example.demo.domain.Meeting.Meeting;

@Mapper
public interface UserMeetingMapper {
	
	//全件取得（ログインしたユーザーID（username)をもとに検索処理）
	@Select("select*from meeting_info where username =#{username}")
    List<Meeting> findAll(String username);
	
	//1件取得(詳細表示）
	@Select("select*from meeting_info where id= #{id}")
	Meeting selectOne(Long id);
	
	//登録処理
	@Insert("insert into meeting_info(roomid,username,people,owner,title,start,end,remarks) values(#{roomid}, #{username}, #{people},#{owner},#{title},#{start},#{end},#{remarks})")
	void insert(Meeting meeting);
	
	//更新処理
	@Update("update meeting_info set roomid=#{roomid}, username=#{username}, start=#{start},end=#{end},people=#{people}, owner=#{owner}, title=#{title},remarks=#{remarks},admincomment=#{admincomment} where id= #{id}")
	void update(Meeting meeting);
	
	//削除処理
	@Delete("delete from meeting_info where id = #{id}")
	void delete(Long id);
	
	//カレンダー表示検索
	//全件検索処理
	@Select("select title,start,end from meeting_info where admincomment=\"承認\"")
	List<DailySummary> findAllReserving(); 	
}
