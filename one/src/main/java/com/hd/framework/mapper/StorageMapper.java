package com.hd.framework.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hd.framework.model.storage.in.StorageEt;
import com.hd.framework.model.storage.in.StoragePageEt;
import com.hd.framework.model.storage.out.StorageProductRt;
import com.hd.framework.model.storage.out.StorageRt;

@Repository
public interface StorageMapper {

	// 添加
	int insert(StorageEt storageEt);

	// 更新
	int update(StorageEt storageEt);

	// 根据ID删除
	int deleteById(int id);

	// 根据ID查询
	StorageRt selectOneById(int id);

	// 分页总条数
	int pageCount(StoragePageEt storagePageEt);

	// 分页
	List<StorageProductRt> page(StoragePageEt storagePageEt);

}
