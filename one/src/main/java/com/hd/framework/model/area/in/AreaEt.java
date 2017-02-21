package com.hd.framework.model.area.in;

import java.util.HashMap;
import java.util.Map;

import com.hd.framework.model.BaseModel;
import com.hd.framework.utils.ValidateUtil;

/**
 * @author yj 区域
 */
public class AreaEt extends BaseModel {

	public int id;

	// 区域编号
	public String num;

	// 区域名称
	public String name;

	// 区域备注
	public String remark;

	public Map<String, Object> valite() {
		Map<String, Object> message = new HashMap<String, Object>();
		if (!ValidateUtil.vStrLen(this.num, true, 6, 16)) {
			message.put("num", "区域编号格式不符");
		}
		if (!ValidateUtil.vStrLen(this.name, true, 1, 16)) {
			message.put("name", "区域名称格式不符");
		}
		return message;
	}

}
