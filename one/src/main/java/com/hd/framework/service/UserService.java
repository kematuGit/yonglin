package com.hd.framework.service;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hd.framework.mapper.UserMapper;
import com.hd.framework.model.user.in.UserEt;
import com.hd.framework.model.user.out.UserRt;

@Service
public class UserService {

	Log logger = LogFactory.getLog(UserService.class);

	@Resource
	private UserMapper userMapper;

	// 添加用户
	public boolean insert(UserEt userEt) {
		try {
			return userMapper.insert(userEt) > 0;
		} catch (Exception e) {
			logger.error("用户添加失败 reason : " + e.getMessage());
			return false;
		}
	}

	// 查询用户
	public UserRt selectOneByUsername(String username) {
		return userMapper.selectOneByUsername(username);
	}

	// 根据ID查询
	public UserRt selectOneById(int userId) {
		return userMapper.selectOneById(userId);
	}

}
