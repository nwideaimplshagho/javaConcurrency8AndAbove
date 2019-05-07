package com.study.concurency.java8above.thread.threadfinalization;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf(" Begining of DataSource loading at time = %s by thread= %s \n",LocalDate.now().toString(),Thread.currentThread().getName());
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf(" Finished of DataSource loading at time = %s by thread= %s \n",LocalDate.now().toString(),Thread.currentThread().getName());
	}

}
