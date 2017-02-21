package com.hd.framework.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hd.framework.model.product.in.ProductEt;
import com.hd.framework.model.product.in.ProductPageEt;
import com.hd.framework.model.product.out.ProductRt;

@Repository
public interface ProductMapper {

	// 添加
	int insert(ProductEt productEt);

	// 更新
	int update(ProductEt productEt);

	// 根据ID删除
	int deleteById(int id);

	// 根据ID查询
	ProductRt selectOneById(int id);

	// 分页总条数
	int pageCount(ProductPageEt productPageEt);

	// 分页
	List<ProductRt> page(ProductPageEt productPageEt);

}
