package com.example.demo.mapper.UserInfo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.UserInfo.UserInfo;

@Mapper
public interface UserInfoMapper {
	//全件検索
	@Select("select*from user_info")
    List<UserInfo> findAll();	
	//1件取得(詳細表示）
	@Select("select*from user_info where username=#{username} ")
    UserInfo selectOne(String username);
	//登録処理
	@Insert("insert into user_info(username,owner,address,workspace,mailaddress,phone,information) values(#{username}, #{owner}, #{address},#{workspace},#{mailaddress},#{phone},#{information})")
	void insert(UserInfo userInfo);
	//更新処理
	@Update("update user_info set username=#{username}, owner=#{owner}, address=#{address},workspace=#{workspace},mailaddress=#{mailaddress},phone=#{phone}, information=#{information} where username= #{username}")
	void update(UserInfo userInfo);

}
