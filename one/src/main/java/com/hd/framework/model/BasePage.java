package com.hd.framework.model;

import java.util.ArrayList;
import java.util.List;

import com.hd.framework.common.Constants;

public class BasePage {

	public List<Object> list;

	public int pageIndex = Constants.DEFAULT_PAGE_INDEX;

	public int totalCount = Constants.DEFAULT_PAGE_SIZE;

	public int totalPage;

	public BasePage() {
		list = new ArrayList<Object>();
	}
}
