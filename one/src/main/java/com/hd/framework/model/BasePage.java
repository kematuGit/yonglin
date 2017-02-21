package com.hd.framework.model;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

	public List<Object> list;

	public int pageIndex;

	public int totalCount;

	public int totalPage;

	public BasePage() {
		list = new ArrayList<Object>();
	}
}
