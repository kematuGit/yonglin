package com.hd.framework.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hd.framework.model.area.in.AreaEt;
import com.hd.framework.model.area.in.AreaPageEt;
import com.hd.framework.model.area.out.AreaRt;

@Repository
public interface AreaMapper {

	// 添加
	int insert(AreaEt areaEt);

	// 更新
	int update(AreaEt areaEt);

	// 根据ID删除
	int deleteById(int id);

	// 根据ID查询
	AreaRt selectOneById(String id);

	// 分页总条数
	int pageCount(AreaPageEt areaPageEt);

	// 分页
	List<AreaRt> page(AreaPageEt areaPageEt);

}
