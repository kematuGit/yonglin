package com.hd.framework.model.product.in;

import java.util.HashMap;
import java.util.Map;

import com.hd.framework.model.BaseModel;
import com.hd.framework.utils.ValidateUtil;

/**
 * @author yj 产品类
 */
public class ProductEt extends BaseModel {

	public int id;

	public int sort;

	// 材料牌号
	public String materialNum;

	// 产品名称
	public String name;

	// 产品图号
	public String picNum;
	
	public String remark;

	public Map<String, Object> valite() {
		Map<String, Object> message = new HashMap<String, Object>();
		if (!ValidateUtil.vStrLen(this.materialNum, true, 6, 16)) {
			message.put("materialNum", "产品材料编号格式不符");
		}
		if (!ValidateUtil.vStrLen(this.name, true, 1, 16)) {
			message.put("name", "产品名称格式不符");
		}
		if (!ValidateUtil.vStrLen(this.picNum, true, 6, 16)) {
			message.put("picNum", "图片编号格式不符");
		}
		return message;
	}
}
