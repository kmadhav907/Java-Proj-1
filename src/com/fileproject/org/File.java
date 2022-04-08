package com.fileproject.org;

import java.time.LocalDate;



public class File {
	public LocalDate get_day() {
		return _day;
	}
	public void set_day(LocalDate _day) {
		this._day = _day;
	}
	public String get_fileName() {
		return _fileName;
	}
	public void set_fileName(String _fileName) {
		this._fileName = _fileName;
	}
	private String _fileAdmin;
	private LocalDate _day;
	private String _fileName;
	private String _dir;
	public String get_dir() {
		return _dir;
	}
	public void set_dir(String _dir) {
		this._dir = _dir;
	}
	
	public File(String _fileAdmin, String _fileName, String _dir) {
		super();
		this._fileAdmin = _fileAdmin;
		this._fileName = _fileName;
		this._dir = _dir;
		this._day = LocalDate.now();
	}
	public File(String _fileAdmin, String _fileName) {
		super();
		this._fileAdmin = _fileAdmin;
		this._fileName = _fileName;
		this._day = LocalDate.now();
		this._dir = "C:\\Users";
	}
	public void displayFileAttributes() {
		System.out.println("FileName:" + this._fileName);
		System.out.println("Located At:" + this._dir);
		System.out.println("Created at:" + this._day);
		System.out.println("By at:" + this._fileAdmin);
		
	}
}