package com.study.concurency.java8above.thread.threadlocal;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

public class SafeThreadVariableTask implements Runnable {
	
	private ThreadLocal<LocalDateTime> tlLdt = new ThreadLocal<LocalDateTime>() {
		protected LocalDateTime initialValue() {
			return LocalDateTime.now(); 
		};
	};
	
	@Override
	public void run() {
		System.out.printf("SafeThreadVariableTask : Started thread with id= %d at time= %s \n", Thread.currentThread().getId(),tlLdt.get().now());
		
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*2));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("SafeThreadVariableTask : Finished thread with id= %d at time= %s \n", Thread.currentThread().getId(),tlLdt.get().now());
	}

}
