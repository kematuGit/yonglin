package com.hd.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author yj
 *	盘查库存
 */
@Controller
@RequestMapping("storage/check")
public class CheckStorageController {

	
	@RequestMapping("/list.php") // 出库列表
	public String list() {
		return "/storage/check/list";
	}
	
	
	@RequestMapping("/edit.php") // 编辑
	public String edit() {
		return "/storage/check/edit";
	}
	
	
	@RequestMapping("/add.php") // 添加
	public String add() {
		return "/storage/check/add";
	}
	
	
}
