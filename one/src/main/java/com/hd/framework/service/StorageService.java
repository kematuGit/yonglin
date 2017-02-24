package com.hd.framework.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hd.framework.common.Constants;
import com.hd.framework.mapper.StorageMapper;
import com.hd.framework.mapper.StorageRackMapper;
import com.hd.framework.model.BasePage;
import com.hd.framework.model.product.out.ProductRt;
import com.hd.framework.model.storage.in.StorageAndRackEt;
import com.hd.framework.model.storage.in.StorageEt;
import com.hd.framework.model.storage.in.StoragePageEt;
import com.hd.framework.model.storage.in.StorageRackEt;
import com.hd.framework.model.storage.in.StorageRackPageEt;
import com.hd.framework.model.storage.out.StorageCountRt;
import com.hd.framework.model.storage.out.StorageDetailRt;
import com.hd.framework.model.storage.out.StorageFindRt;
import com.hd.framework.model.storage.out.StorageProductRt;
import com.hd.framework.model.storage.out.StorageRackRt;
import com.hd.framework.model.storage.out.StorageRt;
import com.hd.framework.utils.PageUtil;

@Service
public class StorageService {

	Log logger = LogFactory.getLog(StorageService.class);

	@Resource
	private StorageMapper storageMapper;

	@Resource
	private StorageRackMapper storageRackMapper;

	@Resource
	private ProductService productService;

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

	// 删除
	public boolean delete(int id) {
		try {
			return storageMapper.deleteById(id) > 0;
		} catch (Exception e) {
			logger.error("删除失败 reason : " + e.getMessage());
			return false;
		}
	}

	// 入库，出库，盘库分页列表
	public BasePage page(StoragePageEt storagePageEt) {
		storagePageEt.plusLike();
		BasePage basePage = new BasePage();
		int total = storageMapper.pageCount(storagePageEt);
		if (total == 0) {
			return basePage;
		}
		basePage.pageIndex = storagePageEt.pageIndex;
		basePage.totalCount = total;
		basePage.totalPage = PageUtil.totalPage(total, storagePageEt.pageSize);

		List<StorageProductRt> beans = storageMapper.page(storagePageEt);
		basePage.list.addAll(beans);
		return basePage;
	}

	// 库存查询
	public BasePage pageFind(StoragePageEt storagePageEt) {
		storagePageEt.plusLike();
		BasePage basePage = new BasePage();
		int total = storageMapper.pageFindCount(storagePageEt);
		if (total == 0) {
			return basePage;
		}
		basePage.pageIndex = storagePageEt.pageIndex;
		basePage.totalCount = total;
		basePage.totalPage = PageUtil.totalPage(total, storagePageEt.pageSize);

		List<StorageFindRt> beans = storageMapper.pageFind(storagePageEt);
		List<Integer> ids = new ArrayList<Integer>();
		for (StorageFindRt rt : beans) {
			ids.add(rt.id);
		}
		if (!CollectionUtils.isEmpty(ids)) {
			List<StorageCountRt> counts = storageMapper.selectCount(storagePageEt);
			for (StorageFindRt bean : beans) {
				for (StorageCountRt count : counts) {
					if (bean.materialReportNum.equals(count.materialReportNum)
							&& bean.productionBatch.equals(count.productionBatch)) {
						if(count.storageType == Constants.STORAGE_TYPE_ONE){
							bean.inStorageCount = count.storageCount;
						}else if(count.storageType == Constants.STORAGE_TYPE_TWO){
							bean.outStorageCount = count.storageCount;
						}else if(count.storageType == Constants.STORAGE_TYPE_THREE){
							bean.checkStorageCount = count.storageCount;
						}
					}
				}
			}

		}
		basePage.list.addAll(beans);
		return null;
	}

	// 货架分页
	public BasePage page(StorageRackPageEt storageRackPageEt) {
		BasePage basePage = new BasePage();
		int total = storageRackMapper.pageCount(storageRackPageEt);
		if (total == 0) {
			return basePage;
		}
		basePage.pageIndex = storageRackPageEt.pageIndex;
		basePage.totalCount = total;
		basePage.totalPage = PageUtil.totalPage(total, storageRackPageEt.pageSize);

		List<StorageRackRt> beans = storageRackMapper.page(storageRackPageEt);
		basePage.list.addAll(beans);
		return basePage;
	}

	// 详情
	public Object detail(int id) {
		StorageDetailRt rt = new StorageDetailRt();
		StorageRt storageRt = storageMapper.selectOneById(id);
		if (storageRt != null) {
			// 赋值库存
			rt.assignment(storageRt);
		}
		// 赋值产品
		ProductRt prodcutRt = productService.selectOneById(storageRt.productId);
		rt.product = prodcutRt;

		// 赋值货架
		StorageRackPageEt storageRackPageEt = new StorageRackPageEt();
		rt.basePage = page(storageRackPageEt);
		return rt;
	}

}
