package com.hd.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.framework.builder.ImgValidateBuilder;

@Controller
@RequestMapping("image")
public class ImageController {

	@RequestMapping("/code.php")
	 public @ResponseBody String getSysManageLoginCode(HttpServletResponse response,
	   HttpServletRequest request) {
	  response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
	  response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
	  response.setHeader("Cache-Control", "no-cache");
	  response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击
	  response.setDateHeader("Expire", 0);
	  ImgValidateBuilder randomValidateCode = new ImgValidateBuilder();
	  try {
	   randomValidateCode.getRandcode(request, response,"imagecode");// 输出图片方法
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return "";
	 }
}
