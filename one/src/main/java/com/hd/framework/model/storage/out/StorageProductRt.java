package com.hd.framework.model.storage.out;

import java.util.Date;

public class StorageProductRt {

	// ID
	public int id;
	
	// (入库，出库，盘点)单号
	public String orderNum;

	// (入库/出库/盘点)日期
	public Date excuteTime;

	// 产品ID
	public int productId;
	
	// 产品名称
	public String proName;
	
	// 产品图号
	public String proPicNum;
	
	// 材料牌号
	public String proMaterialNum;

	// 材料报告编号
	public String materialReportNum;

	// 产品批次
	public String productionBatch;
	
	// 合同号
	public String contactNum;

	// 库存数量
	public int storageNum;

	// 备注
	public String remark;
	
}
