package com.hd.framework.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hd.framework.mapper.AreaMapper;
import com.hd.framework.model.BasePage;
import com.hd.framework.model.area.in.AreaEt;
import com.hd.framework.model.area.in.AreaPageEt;
import com.hd.framework.model.area.out.AreaRt;
import com.hd.framework.utils.PageUtil;

/**
 * @author yj 区域
 */
@Service
public class AreaService {

	Log logger = LogFactory.getLog(AreaService.class);

	@Resource
	private AreaMapper areaMapper;

	// 添加
	public boolean insert(AreaEt model) {
		try {
			return areaMapper.insert(model) > 0;
		} catch (Exception e) {
			logger.error("产品添加失败 reason : " + e.getMessage());
			return false;
		}
	}

	// 删除
	public boolean delete(int id) {
		try {
			return areaMapper.deleteById(id) > 0;
		} catch (Exception e) {
			logger.error("产品删除失败 reason : " + e.getMessage());
			return false;
		}
	}

	// 修改
	public boolean update(AreaEt model) {
		try {
			return areaMapper.update(model) > 0;
		} catch (Exception e) {
			logger.error("产品更新失败 reason : " + e.getMessage());
			return false;
		}
	}

	// 分页查询区域列表
	public BasePage page(AreaPageEt areaPageEt) {
		BasePage basePage = new BasePage();
		int total = areaMapper.pageCount(areaPageEt);
		if (total == 0) {
			return basePage;
		}
		basePage.pageIndex = areaPageEt.pageIndex;
		basePage.totalCount = total;
		basePage.totalPage = PageUtil.totalPage(total, areaPageEt.pageSize);

		List<AreaRt> beans = areaMapper.page(areaPageEt);
		basePage.list.addAll(beans);
		return basePage;
	}

}
