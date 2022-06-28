package com.example.demo.service.UserInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.UserInfo.UserInfo;
import com.example.demo.mapper.UserInfo.UserInfoMapper;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	//①全件取得
	@Transactional
	public List<UserInfo> findAll() {
		return userInfoMapper.findAll();
	}

	//②一件取得
	@Transactional
	public UserInfo selectOne(String username) {
		return userInfoMapper.selectOne(username);
	}

	//③登録
	@Transactional
	public void insert(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
	}

	//④更新
	@Transactional
	public void update(UserInfo userInfo) {
		userInfoMapper.update(userInfo);
	}
}
