package com.study.concurency.java8above.thread.interruptedexception;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

public class FileSearchTest {

	private static FileSearch flSearch;
	
	@BeforeClass
	public static void setUp() {
		flSearch = new FileSearch("G://hello//hello//", "HelloApplication.java");
	}
	
	@Test
	public void test() {
		Thread fileSearchThread = new Thread(flSearch);
		fileSearchThread.start();
		
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		fileSearchThread.interrupt();
	}

}
