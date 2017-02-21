package com.hd.framework.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.framework.common.Constants;
import com.hd.framework.model.common.ResultMap;
import com.hd.framework.model.common.ResultMap.ExcuteResult;
import com.hd.framework.model.storage.in.StorageAndRackEt;
import com.hd.framework.service.StorageService;

/**
 * 
 * @author yj 出库路由
 */
@Controller
@RequestMapping("storage/out")
public class OutStorageController {

	@Resource
	private StorageService storageService;
	
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

	// 出库
	@RequestMapping(value = "/add.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ResultMap.ExcuteResult add(@RequestBody StorageAndRackEt model) {
		ResultMap.ExcuteResult excuteResult = new ExcuteResult();
		Map<String, Object> message = model.valite(Constants.STORAGE_TYPE_TWO);
		if (!message.isEmpty()) {
			excuteResult.success = false;
			excuteResult.errorMap = message;
			return excuteResult;
		}
		boolean result = storageService.excute(model);
		if (result) {
			excuteResult.success = true;
		}
		return excuteResult;
	}

}
