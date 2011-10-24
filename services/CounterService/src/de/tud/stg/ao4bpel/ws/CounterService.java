package de.tud.stg.ao4bpel.ws;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CounterService {

	private Map<String,Integer> counters;
	
	public CounterService() {
		counters = new HashMap<String,Integer>();
	}
	
	public void incrementAsync(String id) {
		this.increment(id);
	}
	
	public Integer increment(String id) {
		if(counters.containsKey(id)) {
			counters.put(id, Integer.valueOf( counters.get(id) + 1));
		}
		else {
			counters.put(id, Integer.valueOf(1));
		}
		return counters.get(id);
	}
	
	public Integer getCount(String id) {
		return counters.get(id);
	}
	
	public String[][] getCounters() {		

		String[][] res = new String[counters.size()][2];
		
		Object[] keys = counters.keySet().toArray();
		Object[] values = counters.values().toArray();

		for (int row = 0; row < keys.length; row++) {
		    res[row][0] = keys[row].toString();
		    res[row][1] = values[row].toString();
		}

		return res;

	}
		
}
