package com.lti.vehicleloan.beans;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class DocumentsUpload {

	
	private List<MultipartFile> files;
	public DocumentsUpload() {
		super();
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public DocumentsUpload(List<MultipartFile> files) {
		super();
		this.files = files;
	}
	@Override
	public String toString() {
		return "DocumentsUpload [files=" + files + "]";
	}


	
	
}
