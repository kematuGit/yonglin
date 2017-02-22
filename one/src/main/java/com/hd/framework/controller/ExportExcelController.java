package com.hd.framework.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hd.framework.utils.ExportExcelUtil;

@Controller
@RequestMapping("export")
public class ExportExcelController {

	public static Log logger = LogFactory.getLog(ExportExcelController.class);

	/**
	 * 导出入库的数据
	 */
	@RequestMapping(value = "in-storage.php", method = RequestMethod.POST)
	public void exportIn(final HttpServletResponse response, @RequestParam("ids") String[] refIds) {
		// List<String> ids = Arrays.asList(refIds);
		ExportExcelUtil.setResponse(response, "学生名单");
		String[] headers = { "入库单号", "入库日期", "产品名称", "产品图号", "材料牌号", "材料报告编号", "生产批号", "入库数量", "备注" };
		String[] fieldNames = { "realname", "username" };
		int[] columnWidthArray = { 20, 40 };
		// List<SchoolUserResult> schoolUserResults = schoolUserService
		// .selectListBySchoolIdUserIdsRoleType(schoolIdUserIdsRoleTypeEntity);
		// TODO list
		List<Object> excelResults = new ArrayList<Object>();
		// excelResults.addAll(schoolUserResults);
		try {
			ExportExcelUtil.exportExcel("导出学生", headers, fieldNames, excelResults, columnWidthArray,
					response.getOutputStream(), ExportExcelUtil.IS2007);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 导出出库的数据
	 */
	@RequestMapping(value = "out-storage.php", method = RequestMethod.POST)
	public void exportOut(final HttpServletResponse response, @RequestParam("ids") String[] refIds) {
		// List<String> ids = Arrays.asList(refIds);
		ExportExcelUtil.setResponse(response, "学生名单");
		String[] headers = { "出库单号", "出库日期", "产品名称", "产品图号", "材料牌号", "材料报告编号", "生产批号", "合同号", "出库数量", "备注" };
		String[] fieldNames = { "orderNum", "username" };
		int[] columnWidthArray = { 20, 40 };
		// List<SchoolUserResult> schoolUserResults = schoolUserService
		// .selectListBySchoolIdUserIdsRoleType(schoolIdUserIdsRoleTypeEntity);
		// TODO list
		List<Object> excelResults = new ArrayList<Object>();
		// excelResults.addAll(schoolUserResults);
		try {
			ExportExcelUtil.exportExcel("导出学生", headers, fieldNames, excelResults, columnWidthArray,
					response.getOutputStream(), ExportExcelUtil.IS2007);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 导出盘点的数据
	 */
	@RequestMapping(value = "check-storage.php", method = RequestMethod.POST)
	public void exportCheck(final HttpServletResponse response, @RequestParam("ids") String[] ids) {
		// List<String> ids = Arrays.asList(refIds);
		ExportExcelUtil.setResponse(response, "学生名单");
		String[] headers = { "盘点单号", "盘点日期", "产品名称", "产品图号", "材料牌号", "材料报告编号", "生产批号", "盘点数量", "备注" };
		String[] fieldNames = { "realname", "username" };
		int[] columnWidthArray = { 20, 40 };
		// List<SchoolUserResult> schoolUserResults = schoolUserService
		// .selectListBySchoolIdUserIdsRoleType(schoolIdUserIdsRoleTypeEntity);
		// TODO list
		List<Object> excelResults = new ArrayList<Object>();
		// excelResults.addAll(schoolUserResults);
		try {
			ExportExcelUtil.exportExcel("导出学生", headers, fieldNames, excelResults, columnWidthArray,
					response.getOutputStream(), ExportExcelUtil.IS2007);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 导出查询的数据
	 */
	@RequestMapping(value = "check-storage.php", method = RequestMethod.POST)
	public void exportFind(final HttpServletResponse response, @RequestParam("ids") String[] ids) {
		// List<String> ids = Arrays.asList(refIds);
		ExportExcelUtil.setResponse(response, "学生名单");
		String[] headers = { "生产批号", "产品名称", "产品图号", "材料牌号", "材料报告编号", "入库数量", "出库数量", "盘点数量", "当前数量" };
		String[] fieldNames = { "realname", "username" };
		int[] columnWidthArray = { 20, 40 };
		// List<SchoolUserResult> schoolUserResults = schoolUserService
		// .selectListBySchoolIdUserIdsRoleType(schoolIdUserIdsRoleTypeEntity);
		// TODO list
		List<Object> excelResults = new ArrayList<Object>();
		// excelResults.addAll(schoolUserResults);
		try {
			ExportExcelUtil.exportExcel("导出学生", headers, fieldNames, excelResults, columnWidthArray,
					response.getOutputStream(), ExportExcelUtil.IS2007);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

}
