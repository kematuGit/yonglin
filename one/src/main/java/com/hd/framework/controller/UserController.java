package com.hd.framework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hd.framework.annotation.CurrentUser;
import com.hd.framework.model.BasePage;
import com.hd.framework.model.CoreUser;
import com.hd.framework.model.user.out.UserRt;
import com.hd.framework.service.UserService;

/**
 * 
 * @author yj 用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/platform.php") // 管理界面
	public String platform(@CurrentUser CoreUser coreUser) {
		return "platform";
	}

	@RequestMapping("/list.php") // 管理界面-右侧部分
	public String list() {
		return "/user/list";
	}

	@RequestMapping("/edit.php") // 管理界面-右侧部分
	public String edit() {
		return "/user/edit";
	}

	@RequestMapping("/list.do") // 管理界面-右侧部分
	public @ResponseBody BasePage ajaxList(@RequestParam(value = "page", required = false) int page,
			@RequestParam(value = "rows", required = false) int rows) {
		BasePage bp = new BasePage();
		return bp;
	}

	@RequestMapping("/selectUser.php") // 管理界面-右侧部分
	public @ResponseBody String selectUser() {
		Gson gson = new Gson();
		UserRt urt = userService.selectOneById(2);
		return gson.toJson(urt);
	}
}
