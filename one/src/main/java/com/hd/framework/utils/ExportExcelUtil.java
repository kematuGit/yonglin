package com.hd.framework.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExportExcelUtil {

	public static Log logger = LogFactory.getLog(ExportExcelUtil.class);

	public static final String IS2007 = "IS2007";

	public static void setResponse(HttpServletResponse response, String name) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String fileName = sdf.format(new Date()) + "-" + name;
			String strFileName = new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xlsx";
			String ContentDisposition = "attachment; filename=\"" + strFileName;
			response.setHeader("Content-Disposition", ContentDisposition);
		} catch (UnsupportedEncodingException e1) {
			logger.error(e1.getMessage());
			;
		}
		response.setContentType("application/octet-stream; charset=UTF-8");
	}

	public static void exportExcel(String sheetTitle, String[] headers, String[] refFieldNames, List<Object> dataset,
			int[] columnWidthArray, OutputStream out, String refSuffix) {
		exportExcel(sheetTitle, headers, refFieldNames, dataset, columnWidthArray, out, "yyyy-MM-dd", refSuffix);
	}

	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * @param title
	 *            表格标题名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 */
	public static void exportExcel(String title, String[] headers, String[] refFieldNames, List<Object> dataset,
			int[] columnWidthArray, OutputStream out, String pattern, String refSuffix) {
		Workbook workbook = null;
		// 声明一个工作薄
		if (refSuffix.equals(IS2007)) {
			workbook = new XSSFWorkbook();
		} else {
			workbook = new HSSFWorkbook();
		}
		// 生成一个表格
		Sheet sheet = workbook.createSheet(title);

		for (int i = 0; i < columnWidthArray.length; i++) {
			// 设置表格默认列宽度为15个字节
			sheet.setColumnWidth((short) i, (short) columnWidthArray[i] * 256);
		}

		// 生成一个样式
		CellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		// style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		Font font = workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		// 生成并设置另一个样式
		CellStyle style2 = workbook.createCellStyle();
		// style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		// style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//设置背景颜色
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// 声明一个画图的顶级管理器
		Drawing patriarch = sheet.createDrawingPatriarch();

		// 产生表格标题行
		Row row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(headers[i]);
		}

		// 遍历集合数据，产生数据行
		Iterator<Object> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			Object t = it.next();
			// Cell numberCell = row.createCell(0);
			// numberCell.setCellStyle(style2);
			// numberCell.setCellValue(index);
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			for (short i = 0; i < refFieldNames.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(style2);
				Field field = null;
				try {
					field = t.getClass().getField(refFieldNames[i]);
				} catch (NoSuchFieldException e2) {
					logger.error(e2.getMessage());
				} catch (SecurityException e2) {
					logger.error(e2.getMessage());
				}
				field.setAccessible(true);// 设置当前对象对model私有属性的访问权限\
				Object value = null;
				try {
					value = field.get(t);
				} catch (IllegalArgumentException e1) {
					logger.error(e1.getMessage());
				} catch (IllegalAccessException e1) {
					logger.error(e1.getMessage());
				}

				try {
					// 判断值的类型后进行强制类型转换
					String textValue = null;
					if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);
					} else if (value instanceof byte[]) {
						// 有图片时，设置行高为60px;
						row.setHeightInPoints(60);
						// 设置图片所在列宽度为80px,注意这里单位的一个换算
						sheet.setColumnWidth(i, (short) (35.7 * 80));
						// sheet.autoSizeColumn(i);
						byte[] bsValue = (byte[]) value;
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, index, (short) 6,
								index);
						anchor.setAnchorType(2);
						patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value.toString();
					}
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							cell.setCellValue(textValue);
						}
					}
				} catch (SecurityException e) {
					logger.error(e.getMessage());
				} finally {
					// 清理资源
				}
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
	}
}
