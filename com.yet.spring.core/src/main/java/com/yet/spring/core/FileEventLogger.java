package com.yet.spring.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger {
	
	private String filename;
	private File file;
	
	protected void init() throws IOException {
		file = new File(filename);
		
		if (!file.createNewFile() && !file.canWrite()) {
			throw new IOException("No write permissions to " + filename);
		}
	}

	public FileEventLogger(String filename) {
		super();
		this.filename = filename;
	}

	public void logEvent(Event event) {
		try {
			FileUtils.writeStringToFile(file, event.toString(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
