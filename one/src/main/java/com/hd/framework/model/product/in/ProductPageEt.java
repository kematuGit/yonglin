package com.hd.framework.model.product.in;

import org.springframework.util.StringUtils;

import com.hd.framework.model.PageQuery;

public class ProductPageEt extends PageQuery {

	// 材料牌号
	public String materialNum;

	// 产品名称
	public String name;

	// 产品图号
	public String picNum;
	
	public void plusLike() {
		if (!StringUtils.isEmpty(materialNum)) {
			this.materialNum = this.materialNum + "%";
		}
		if (!StringUtils.isEmpty(name)) {
			this.name = "%" + this.name + "%";
		}
		if (!StringUtils.isEmpty(picNum)) {
			this.picNum = this.picNum + "%";
		}
	}

}
