package com.hd.framework.model.storage.in;

import java.util.List;
import java.util.Map;

public class StorageAndRackEt extends StorageEt {

	public List<StorageRackEt> storageRacks;

	public Map<String, Object> valite(int type) {
		Map<String, Object> message = super.valite(type);
		// message.putAll(m);
		return message;
	}

	public StorageEt newStorage() {
		StorageEt bean = new StorageEt();
		bean.id = this.id;
		bean.orderNum = this.orderNum;
		bean.excuteTime = this.excuteTime;
		bean.productId = this.productId;
		bean.materialReportNum = this.materialReportNum;
		bean.productionBatch = this.productionBatch;
		bean.storageNum = this.storageNum;
		bean.contactNum = this.contactNum;
		bean.remark = this.remark;
		bean.storageType = this.storageType;
		return bean;
	}
}
