package com.hd.framework.view;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hd.framework.model.BasicUser;
import com.hd.framework.utils.DateUtil;
import com.hd.framework.utils.SessionUtil;

public class FreeMarkerView extends org.springframework.web.servlet.view.freemarker.FreeMarkerView {

	@Override
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		model.put("baseUrl", request.getContextPath());
		Date nowTime = new Date();
		String str_nowTime = DateUtil.format(nowTime, DateUtil.YMD) + "&nbsp;" + DateUtil.getWeekOfDate(nowTime);
		model.put("nowTime", str_nowTime);
		BasicUser basicUser = SessionUtil.currentUser(request);
		if (basicUser != null) {
			model.put("currentUser", basicUser);
		}
		super.exposeHelpers(model, request);
	}
}
