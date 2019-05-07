package com.study.concurency.java8above.thread.threadfinalization;

import java.time.LocalDateTime;

public class ThreadFinalizationVerifier {

	public static void main(String[] args) {
		Thread dsLdrThd = new Thread(new DataSourceLoader(), "DSLoader");
		Thread nwLdrThd = new Thread(new NetworkLoader(),"NtWkLoader");
		
		dsLdrThd.start();
		nwLdrThd.start();
		
		
		try {
			dsLdrThd.join();
			nwLdrThd.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main thread execution finished at time= %s \n", LocalDateTime.now().toString());
	}

}
