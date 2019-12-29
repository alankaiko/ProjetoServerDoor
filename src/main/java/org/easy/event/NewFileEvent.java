package org.easy.event;

import java.io.File;
import java.io.Serializable;

public class NewFileEvent implements Serializable{
	private static final long serialVersionUID = 1L;

	public NewFileEvent(File file){
		this.file = file;
	}
	
	private final File file;

	public File getFile() {
		return file;
	}
}
