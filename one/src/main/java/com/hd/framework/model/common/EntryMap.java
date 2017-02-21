package com.hd.framework.model.common;

import java.util.HashMap;
import java.util.Map;

public abstract class EntryMap {

	public static class Id {

		public int id;

		public Map<String, Object> valite() {
			Map<String, Object> message = new HashMap<String, Object>();
			if (this.id > 0) {
				message.put("id", "id不能为空");
			}
			return message;
		}
	}
}
