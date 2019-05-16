package com.study.concurency.java8above.thread.threadlocal;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class UnsafeThreadVarialeTask implements Runnable {
	
	private LocalDateTime ldt = null; 
	
	@Override
	public void run() {
		ldt = LocalDateTime.now();
		System.out.printf(" UnsafeThreadVarialeTask : Started thread with id= %d at time= %s \n", Thread.currentThread().getId(),ldt);
		
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*2));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ldt = LocalDateTime.now();
		System.out.printf(" UnsafeThreadVarialeTask : Finished thread with id= %d at time= %s \n", Thread.currentThread().getId(),ldt);
	}

}
