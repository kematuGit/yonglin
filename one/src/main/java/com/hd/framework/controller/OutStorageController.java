package com.hd.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author yj
 * 出库路由
 */
@Controller
@RequestMapping("storage/out")
public class OutStorageController {

	@RequestMapping("/list.php") // 入库列表
	public String center() {
		return "/storage/out/list";
	}
	
	@RequestMapping("/edit.php") // 编辑
	public String edit() {
		return "/storage/out/edit";
	}
	
	
	@RequestMapping("/add.php") // 添加
	public String add() {
		return "/storage/out/add";
	}
	
}
