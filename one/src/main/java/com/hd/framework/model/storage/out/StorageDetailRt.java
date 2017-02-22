package com.hd.framework.model.storage.out;

import com.hd.framework.model.BasePage;
import com.hd.framework.model.product.out.ProductRt;

// 库存详情
public class StorageDetailRt extends StorageRt {

	// 产品
	public ProductRt product;

	// 货架列表
	public BasePage basePage;

	public void assignment(StorageRt storageRt) {
		this.id = storageRt.id;
		// (入库，出库，盘点)单号
		this.orderNum = storageRt.orderNum;
		// (入库/出库/盘点)日期
		this.excuteTime = storageRt.excuteTime;
		// 产品ID
		this.productId = storageRt.productId;
		// 材料报告编号
		this.materialReportNum = storageRt.materialReportNum;
		// 产品批次
		this.productionBatch = storageRt.productionBatch;
		// 库存数量
		this.storageNum = storageRt.storageNum;
		// 合同号
		this.contactNum = storageRt.contactNum;
		// 备注
		this.remark = storageRt.remark;

	}

}
