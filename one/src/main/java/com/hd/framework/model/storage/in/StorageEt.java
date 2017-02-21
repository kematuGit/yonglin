package com.hd.framework.model.storage.in;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hd.framework.model.BaseModel;
import com.hd.framework.utils.ValidateUtil;

/**
 * 
 * @author yj 库存
 *
 */
public class StorageEt extends BaseModel {

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

	// 库存类型（1:入库 2:出库 3：盘点）
	public int storageType;

	public Map<String, Object> valite(int type) {
		Map<String, Object> message = new HashMap<String, Object>();
		if (!ValidateUtil.vStrLen(this.orderNum, true, 6, 16)) {
			message.put("orderNum", "入库单号格式不符");
		}
		String messType = null;
		if (type == 1) {
			messType = "入库";
		}
		if (type == 2) {
			messType = "出库";
		}
		if (type == 3) {
			messType = "盘点";
		}
		if (this.excuteTime != null) {
			message.put("excuteTime", messType + "时间不能为空");
		}
		if (this.productId <= 0) {
			message.put("productId", "请选择图片");
		}
		if (!ValidateUtil.vStrLen(this.materialReportNum, true, 6, 16)) {
			message.put("materialReportNum", "材料报告编号格式不符合");
		}
		if (!ValidateUtil.vStrLen(this.productionBatch, true, 4, 16)) {
			message.put("productionBatch", "产品批次格式不服");
		}
		if (this.storageNum <= 0) {
			message.put("storageNum", messType+"库存数要大于零");
		}
		if (type == 2 || type == 3) {
			if(!ValidateUtil.vStrLen(this.contactNum, true, 4, 16)){
				message.put("contactNum", "合同号格式不符");
			}
		}
		return message;
	}
}
