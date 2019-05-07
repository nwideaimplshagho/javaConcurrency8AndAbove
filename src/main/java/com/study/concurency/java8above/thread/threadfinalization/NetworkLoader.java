package com.study.concurency.java8above.thread.threadfinalization;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class NetworkLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf(" Begining of NetworkLoader loading at time = %s by thread= %s \n",LocalDate.now().toString(),Thread.currentThread().getName());
		
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf(" Finished of NetworkLoader loading at time = %s by thread= %s \n",LocalDate.now().toString(),Thread.currentThread().getName());
	}

}
