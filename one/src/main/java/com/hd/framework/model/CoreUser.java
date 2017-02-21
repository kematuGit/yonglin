package com.hd.framework.model;

import java.util.Date;

import com.hd.framework.model.user.out.UserRt;

public class CoreUser extends BasicUser{

	public int id;

	public String username;

	public String password;

	// 用户角色
	public int role;

	public int sex;

	public String mobile;

	public Date updateTime;

	public Date createTime;
	
	public CoreUser(UserRt userRt){
		this.id = userRt.id;
		this.username = userRt.username;
		this.password = userRt.password;
		this.role = userRt.role;
		this.sex = userRt.sex;
		this.mobile = userRt.mobile;
		this.updateTime = userRt.updateTime;
		this.createTime = userRt.createTime;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public int getSex() {
		return sex;
	}

	public String getMobile() {
		return mobile;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}
	
	
}
