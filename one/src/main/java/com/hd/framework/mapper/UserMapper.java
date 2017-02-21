package com.hd.framework.mapper;

import org.springframework.stereotype.Repository;

import com.hd.framework.model.user.in.UserEt;
import com.hd.framework.model.user.out.UserRt;

@Repository
public interface UserMapper {

	// 添加
	int insert(UserEt userEt);

	// 根据用户ID查询
	UserRt selectOneById(int userId);

	// 根据 username 查询
	UserRt selectOneByUsername(String username);

	
}