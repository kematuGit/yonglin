package com.hd.framework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.framework.common.Constants;
import com.hd.framework.model.BasePage;
import com.hd.framework.model.storage.in.StoragePageEt;
import com.hd.framework.service.StorageService;

/**
 * 
 * @author yj 查询库存
 *
 */
@Controller
@RequestMapping("storage/select")
public class SelectStorageController {

	@Resource
	private StorageService storageService;

	@RequestMapping("/list.php") // 入库列表
	public String center() {
		return "/storage/in/list";
	}

	// 分页查询
	@RequestMapping(value = "/page.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody BasePage page(@RequestBody StoragePageEt storagePageEt) {
		storagePageEt.storageType = Constants.STORAGE_TYPE_ONE;
		return storageService.pageFind(storagePageEt);
	}
}
