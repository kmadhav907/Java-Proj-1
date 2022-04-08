package com.fileproject.org;

import java.util.Comparator;

public class FileSortByName implements Comparator<File> {
	@Override
	public int compare(File o1, File o2) {
		return o1.get_fileName().compareTo(o2.get_fileName());
	}
}
