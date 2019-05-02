package com.study.concurency.java8above.thread.interruptedexception;

import java.io.File;
import java.util.Arrays;

public class FileSearch implements Runnable {

	private String initPath;
	private String searchFileName; 
	
	public FileSearch(String initPath, String searchfileName) {
		this.initPath = initPath;
		this.searchFileName = searchfileName;
	}
	
	@Override
	public void run() {
		File fl = new File(this.initPath);
		
		if (fl.isDirectory()) {
			try {
				directoryProcess(fl);
			} catch (InterruptedException e) {
				System.out.printf(" Thread named= %s has been interrupted \n ", Thread.currentThread().getName());
			}
		}
				
	}

	private void directoryProcess(File fl) throws InterruptedException {
		
		File[] filesArr = fl.listFiles();
		boolean isFound = false;
		
		for (int i = 0; i < filesArr.length; i++) {
			File file = filesArr[i];
			if (file.isDirectory()) {
				directoryProcess(file);
			} else {
				if(fileProcess(file)) {
					isFound = true;
					break;
				}
			}
		}
		
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
		
		if (isFound) {
			System.out.printf(" File %s has found \n", searchFileName);
			return;
		}
	}

	private boolean fileProcess(File file) throws InterruptedException {
		boolean isFound = false;
		System.out.printf(" Current file name %s \n", file.getName());
		if (file.getName().equalsIgnoreCase(searchFileName)) {
			isFound = true;
			System.out.printf(" fileProcess : Thread %s found file %s \n ", Thread.currentThread().getName(),file.getName());
		}
		
		if (Thread.interrupted()) {
			isFound = isFound || false;
			throw new InterruptedException();
		}
		
		return isFound;
	}

}
