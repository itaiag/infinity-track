package il.co.topq.rest.utils;

import java.util.Map;

public class IdUtils {

	private IdUtils(){
		
	}
	
	public static <T> int getAvailableId(Map<Integer, T> mapWithIds) {
		if (mapWithIds.isEmpty()) {
			return 0;
		}
		int maxId = 0;
		for (Integer id : mapWithIds.keySet()) {
			if (id > maxId) {
				maxId = id;
			}

		}
		return ++maxId;
	}

	
}
