package com.example.demo.mapper.UserInfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.UserInfo.UserInfo;

@Mapper
public interface UserInfoMapper {
	//全件検索
    List<UserInfo> findAll();	
	//1件取得(詳細表示）
    UserInfo selectOne(String username);
	//登録処理
	void insert(UserInfo userInfo);
	//更新処理
	void update(UserInfo userInfo);
	//削除処理
	void delete(Long id);
}
