package com.hd.framework.model.storage.out;

import java.util.Date;

public class StorageRt {

	public int id;

	// (入库，出库，盘点)单号
	public String orderNum;

	// (入库/出库/盘点)日期
	public Date excuteTime;

	// 产品ID
	public int productId;

	// 材料报告编号
	public String materialReportNum;

	// 产品批次
	public String productionBatch;

	// 库存数量
	public int storageNum;

	// 合同号
	public String contactNum;

	// 备注
	public String remark;
}
