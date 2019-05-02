package com.study.concurency.java8above.thread.sleepingresuming;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class PeriodicClock implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.printf(" Current time is= %s \n ", LocalDateTime.now().toString());
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.printf(" PeriodicClock thread %s has been interrupted at time = %s \n", Thread.currentThread().getName(),LocalDateTime.now().toString());
			}
		}
		
	}

}
