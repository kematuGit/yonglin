package com.hd.framework.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hd.framework.model.storage.in.StorageEt;
import com.hd.framework.model.storage.in.StoragePageEt;
import com.hd.framework.model.storage.out.StorageProductRt;

@Repository
public interface StorageMapper {

	// 添加
	boolean insert(StorageEt storageEt);

	// 更新
	boolean update(StorageEt storageEt);

	// 根据ID删除
	boolean deleteById(String id);

	// 根据ID查询
	boolean selectOneById(String id);

	// 分页总条数
	int pageCount(StoragePageEt storagePageEt);

	// 分页
	List<StorageProductRt> page(StoragePageEt storagePageEt);

}
