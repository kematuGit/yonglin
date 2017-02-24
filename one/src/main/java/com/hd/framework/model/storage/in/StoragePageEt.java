package com.hd.framework.model.storage.in;

import org.springframework.util.StringUtils;

import com.hd.framework.model.PageQuery;

/**
 * 
 * @author yj 分页
 */
public class StoragePageEt extends PageQuery {

	// (入库，出库，盘点)单号
	public String orderNum;

	// 产品名称
	public String productName;

	// 产品图号
	public String proPicNum;

	// 产品材料牌号
	public String proMaterialNum;

	// 材料报告编号
	public String materialReportNum;

	// 生产批次
	public String productionBatch;

	// (入库，出库，盘点) 开始时间
	public String startTime;

	// (入库，出库，盘点) 结束时间
	public String endTime;

	// 库存类型（1:入库 2:出库 3：盘点）
	public int storageType;

	public void plusLike() {
		if (!StringUtils.isEmpty(orderNum)) {
			this.orderNum = this.orderNum + "%";
		}
		if (!StringUtils.isEmpty(productName)) {
			this.productName = "%" + this.productName + "%";
		}
		if (!StringUtils.isEmpty(proPicNum)) {
			this.proPicNum = this.proPicNum + "%";
		}
		if (!StringUtils.isEmpty(proMaterialNum)) {
			this.proMaterialNum = this.proMaterialNum + "%";
		}
		if (!StringUtils.isEmpty(materialReportNum)) {
			this.materialReportNum = this.materialReportNum + "%";
		}
		if (!StringUtils.isEmpty(productionBatch)) {
			this.productionBatch = this.productionBatch + "%";
		}
	}

}
