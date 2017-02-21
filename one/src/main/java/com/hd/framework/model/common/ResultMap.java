package com.hd.framework.model.common;

import java.util.Map;

public abstract class ResultMap {

	public static class ExcuteResult{
		
		public boolean success;
		
		public Map<String,Object> errorMap;
		
	}
	
}
