package com.study.concurency.java8above.thread.threadlocal;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadLocalVarialeTaskTest {

	@Test
	public void testUnsafeTask() {
		UnsafeThreadVarialeTask utvt = new UnsafeThreadVarialeTask();
		
		for (int i = 0; i < Runtime.getRuntime().availableProcessors()*2; i++) {
			Thread th = new Thread(utvt);
			th.start();
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testSafeTask() {
		SafeThreadVariableTask stvt = new SafeThreadVariableTask();
		
		for (int i = 0; i < Runtime.getRuntime().availableProcessors()*2; i++) {
			Thread th = new Thread(stvt);
			th.start();
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
