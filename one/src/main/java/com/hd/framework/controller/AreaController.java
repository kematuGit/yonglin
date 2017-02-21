package com.hd.framework.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.framework.model.BasePage;
import com.hd.framework.model.area.in.AreaEt;
import com.hd.framework.model.area.in.AreaPageEt;
import com.hd.framework.model.common.EntryMap;
import com.hd.framework.model.common.ResultMap;
import com.hd.framework.model.common.ResultMap.ExcuteResult;
import com.hd.framework.service.AreaService;

@Controller
@RequestMapping("area")
public class AreaController {

	@Resource
	private AreaService areaService;

	// 添加产品
	@RequestMapping(value = "/add.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ResultMap.ExcuteResult add(@RequestBody AreaEt model) {
		ResultMap.ExcuteResult excuteResult = new ExcuteResult();
		Map<String, Object> message = model.valite();
		if (!message.isEmpty()) {
			excuteResult.success = false;
			excuteResult.errorMap = message;
			return excuteResult;
		}
		boolean result = areaService.insert(model);
		if (result) {
			excuteResult.success = true;
		}
		return excuteResult;
	}

	// 删除产品
	@RequestMapping(value = "/del.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ResultMap.ExcuteResult add(@RequestBody EntryMap.Id model) {
		ResultMap.ExcuteResult excuteResult = new ExcuteResult();
		Map<String, Object> message = model.valite();
		if (!message.isEmpty()) {
			excuteResult.success = false;
			excuteResult.errorMap = message;
			return excuteResult;
		}
		boolean result = areaService.delete(model.id);
		if (result) {
			excuteResult.success = true;
		}
		return excuteResult;
	}

	// 修改产品
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public @ResponseBody ResultMap.ExcuteResult edit(@RequestBody AreaEt areaEt) {
		ResultMap.ExcuteResult excuteResult = new ExcuteResult();
		Map<String, Object> message = areaEt.valite();
		if (!message.isEmpty()) {
			excuteResult.success = false;
			excuteResult.errorMap = message;
			return excuteResult;
		}
		boolean result = areaService.update(areaEt);
		if (result) {
			excuteResult.success = true;
		}
		return excuteResult;
	}

	// 查询产品
	@RequestMapping(value = "/page.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody BasePage page(@RequestBody AreaPageEt areaPageEt) {
		return areaService.page(areaPageEt);
	}

}
