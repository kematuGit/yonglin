package com.hd.framework.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hd.framework.model.storage.in.StorageRackEt;
import com.hd.framework.model.storage.in.StorageRackPageEt;
import com.hd.framework.model.storage.out.StorageRackRt;

@Repository
public interface StorageRackMapper {

	// 添加
	int insert(StorageRackEt storageRackEt);

	// 更新
	int update(StorageRackEt storageRackEt);

	// 根据ID删除
	int deleteById(int id);

	// 根据ID查询
	boolean selectOneById(int id);

	// 分页总条数
	int pageCount(StorageRackPageEt storageRackPageEt);

	// 分页
	List<StorageRackRt> page(StorageRackPageEt storageRackPageEt);

}
