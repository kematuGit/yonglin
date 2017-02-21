package com.hd.framework.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.framework.model.BasePage;
import com.hd.framework.model.common.EntryMap;
import com.hd.framework.model.common.ResultMap;
import com.hd.framework.model.common.ResultMap.ExcuteResult;
import com.hd.framework.model.product.in.ProductEt;
import com.hd.framework.model.product.in.ProductPageEt;
import com.hd.framework.service.ProductService;

/**
 * 
 * @author yj 产品
 */
@Controller
@RequestMapping("product")
public class ProductController {

	@Resource
	private ProductService productService;

	// 添加产品
	@RequestMapping(value = "/add.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ResultMap.ExcuteResult add(@RequestBody ProductEt model) {
		ResultMap.ExcuteResult excuteResult = new ExcuteResult();
		Map<String, Object> message = model.valite();
		if(!message.isEmpty()){
			excuteResult.success = false;
			excuteResult.errorMap = message;
			return excuteResult;
		}
		boolean result = productService.insert(model);
		if(result){
			excuteResult.success = true;
		}
		return excuteResult;
	}
	
	// 删除产品
	@RequestMapping(value = "/del.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ResultMap.ExcuteResult add(@RequestBody EntryMap.Id model) {
		ResultMap.ExcuteResult excuteResult = new ExcuteResult();
		Map<String, Object> message = model.valite();
		if(!message.isEmpty()){
			excuteResult.success = false;
			excuteResult.errorMap = message;
			return excuteResult;
		}
		boolean result = productService.delete(model.id);
		if(result){
			excuteResult.success = true;
		}
		return excuteResult;
	}
	
	
	// 修改产品
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public @ResponseBody ResultMap.ExcuteResult edit(@RequestBody ProductEt productEt) {
		ResultMap.ExcuteResult excuteResult = new ExcuteResult();
		Map<String, Object> message = productEt.valite();
		if(!message.isEmpty()){
			excuteResult.success = false;
			excuteResult.errorMap = message;
			return excuteResult;
		}
		boolean result = productService.update(productEt);
		if(result){
			excuteResult.success = true;
		}
		return excuteResult;
	}
	
	// 查询产品
	@RequestMapping(value = "/page.do", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody BasePage page(@RequestBody ProductPageEt productPageEt) {
		return productService.page(productPageEt);
	}

}
