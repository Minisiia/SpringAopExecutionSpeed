package execution_speed.objects;

import java.io.File;
import java.io.FilenameFilter;

public class CustomFileFilter implements FilenameFilter {

	private String extension;

	public CustomFileFilter(String extension) {
		this.extension = extension;
	}


	public boolean accept(File file, String name) {
		return name.toUpperCase().endsWith("." + extension.toUpperCase());
	}

}
