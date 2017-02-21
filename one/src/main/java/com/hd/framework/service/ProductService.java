package com.hd.framework.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hd.framework.mapper.ProductMapper;
import com.hd.framework.model.BasePage;
import com.hd.framework.model.product.in.ProductEt;
import com.hd.framework.model.product.in.ProductPageEt;
import com.hd.framework.model.product.out.ProductRt;
import com.hd.framework.utils.PageUtil;

/**
 * @author yj
 * 产品
 */
@Service
public class ProductService {

	Log logger = LogFactory.getLog(ProductService.class);
	
	@Resource
	private ProductMapper productMapper;
	
	// 添加
	public boolean insert(ProductEt model) {
		try {
			return productMapper.insert(model) > 0;
		} catch (Exception e) {
			logger.error("产品添加失败 reason : " + e.getMessage());
			return false;
		}
	}
	
	// 删除
	public boolean delete(int id) {
		try {
			return productMapper.deleteById(id) > 0;
		} catch (Exception e) {
			logger.error("产品删除失败 reason : " + e.getMessage());
			return false;
		}
	}
	
	// 修改
	public boolean update(ProductEt model) {
		try {
			return productMapper.update(model) > 0;
		} catch (Exception e) {
			logger.error("产品更新失败 reason : " + e.getMessage());
			return false;
		}
	}
	
	// 分页查询产品列表
	public BasePage page(ProductPageEt productPageEt){
		productPageEt.plusLike();
		BasePage basePage = new BasePage();
		int total = productMapper.pageCount(productPageEt);
		if(total==0){
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
