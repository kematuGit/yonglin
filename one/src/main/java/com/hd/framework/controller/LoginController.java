package com.hd.framework.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.framework.annotation.CurrentUser;
import com.hd.framework.common.Constants;
import com.hd.framework.model.BasicUser;
import com.hd.framework.model.common.ResultMap;
import com.hd.framework.model.common.ResultMap.ExcuteResult;
import com.hd.framework.model.product.in.ProductEt;
import com.hd.framework.model.user.in.LoginEt;
import com.hd.framework.model.user.in.UserEt;
import com.hd.framework.service.LoginService;
import com.hd.framework.service.ProductService;
import com.hd.framework.service.UserService;
import com.hd.framework.utils.CookieUtil;
import com.hd.framework.utils.SessionUtil;
import com.hd.framework.utils.StringUtil;
/**
 * 
 * @author yj
 *	登录
 *
 */
@Controller
public class LoginController {

	@Resource
	private LoginService loginService;

	// 主页
	@RequestMapping("")
	public String index() {
		return "index";
	}

	// 登录入口
	@RequestMapping("/login.php")
	public String login(@CurrentUser BasicUser basicUser) {
		if(basicUser!=null)
			return "redirect:/user/platform.php";
		return "login";
	}
	
	// 登出
	@RequestMapping("/logOut.php")
	public String logOut(HttpServletRequest request,
			HttpServletResponse response) {
		SessionUtil.remove(request, Constants.SESSION_NAME);
		CookieUtil.remove(request, Constants.COOKIE_NAME);
		return "redirect:/login.php";
	}

	// 异步登录
	@RequestMapping(value = "/login.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ResultMap.ExcuteResult insertPatient(@RequestBody LoginEt loginEt, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ResultMap.ExcuteResult excuteResult = new ExcuteResult();
		Map<String, Object> message = loginEt.valite();
		if (message.isEmpty()) {
			boolean isLogin = loginService.checkLogin(loginEt, session, response);
			if (!isLogin) {
				message.put("login", "账号或密码错误");
				excuteResult.success = false;
			} else {
				excuteResult.success = true;
			}
		}
		excuteResult.errorMap = message;
		return excuteResult;
	}

	 
	
	@Resource
	private UserService userService;
	@Resource
	private ProductService productService;
	
	// 测试数据
	@RequestMapping("/insert.php") // 管理界面-右侧部分
	public @ResponseBody String insert() {
		for(int i=0;i<1000;i++){
			UserEt model = new UserEt();
			model.username = "tck"+(i+1);
			model.password = "123456";
			model.role = 2;
			model.sex = 1;
			userService.insert(model);
		}
		return "ok";
	}
	
	@RequestMapping("/insertProduct.php") // 管理界面-右侧部分
	public @ResponseBody String insertProduct() {
		for (int i = 0; i < 1000; i++) {
			ProductEt model = new ProductEt();
			model.sort = i + 1;
			model.materialNum = "20170209" + StringUtil.format(3, i);
			model.name = "产品" + i;
			model.picNum = "T20170209" + StringUtil.format(3, i);
			model.remark = "备注产品" + i;
			boolean result = productService.insert(model);
			System.out.println(result);
		}
		return "ok";
	}
}
