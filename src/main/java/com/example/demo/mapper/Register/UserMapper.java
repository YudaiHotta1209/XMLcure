package com.example.demo.mapper.Register;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Login.User;

@Mapper
public interface UserMapper{
	
	//１件取得→ログイン用
	@Select("select*from users where username = #{username}")
	Optional<User> findByUsername(String username);
	
	//全件取得
	@Select("select*from users")
	List<User>findAll();
	
	//登録処理
	@Insert("insert into users(username, password, authority) values (#{username},#{password}, #{authority})")
	void insert(String username, String password, String authority);
	

}