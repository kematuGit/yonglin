package com.hd.framework.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hd.framework.mapper.StorageMapper;
import com.hd.framework.mapper.StorageRackMapper;
import com.hd.framework.model.BasePage;
import com.hd.framework.model.product.in.ProductPageEt;
import com.hd.framework.model.product.out.ProductRt;
import com.hd.framework.model.storage.in.StorageAndRackEt;
import com.hd.framework.model.storage.in.StorageEt;
import com.hd.framework.model.storage.in.StoragePageEt;
import com.hd.framework.model.storage.in.StorageRackEt;
import com.hd.framework.utils.PageUtil;

@Service
public class StorageService {

	Log logger = LogFactory.getLog(StorageService.class);

	@Resource
	private StorageMapper storageMapper;

	@Resource
	private StorageRackMapper storageRackMapper;

	// 执行入库，出库，盘库的操作
	public boolean excute(StorageAndRackEt model) {
		try {
			if (model.id > 0) {
				storageMapper.update(model.newStorage());
				if (!CollectionUtils.isEmpty(model.storageRacks)) {
					for (StorageRackEt bean : model.storageRacks) {
						if (bean.id > 0) {
							storageRackMapper.update(bean);
						} else {
							bean.storageId = model.id;
							storageRackMapper.insert(bean);
						}
					}
				}
			} else {
				StorageEt entity = model.newStorage();
				storageMapper.insert(entity);
				if (!CollectionUtils.isEmpty(model.storageRacks)) {
					for (StorageRackEt bean : model.storageRacks) {
						bean.storageId = entity.id;
						storageRackMapper.insert(bean);
					}
				}
			}
			return true;
		} catch (Exception e) {
			logger.error("添加失败 reason：" + e.getMessage());
			return false;
		}
	}

	// 入库，出库，盘库分页列表
	public BasePage page(StoragePageEt storagePageEt) {
		storagePageEt.plusLike();
		BasePage basePage = new BasePage();
		int total = productMapper.pageCount(productPageEt);
		if (total == 0) {
			return basePage;
		}
		basePage.pageIndex = productPageEt.pageIndex;
		basePage.totalCount = total;
		basePage.totalPage = PageUtil.totalPage(total, productPageEt.pageSize);

		List<ProductRt> beans = productMapper.page(productPageEt);
		basePage.list.addAll(beans);
		return basePage;
	}

}
