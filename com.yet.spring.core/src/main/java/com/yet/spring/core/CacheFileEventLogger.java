package com.yet.spring.core;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
	private int cacheSize;
	private List<Event> cache = new ArrayList<Event>();;
	
	public CacheFileEventLogger(String filename, int cacheSize) {
		super(filename);
		this.cacheSize = cacheSize;
	}
	
	private void writeEventsFromCache() {
		for (Event event: cache) {
			super.logEvent(event);
		}
	}

	@Override
	public void logEvent(Event event) {
		cache.add(event);
		
		if (cache.size() == cacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}

	protected void destroy() {
		if (!cache.isEmpty()) {
			writeEventsFromCache();
		}	
	}
}
