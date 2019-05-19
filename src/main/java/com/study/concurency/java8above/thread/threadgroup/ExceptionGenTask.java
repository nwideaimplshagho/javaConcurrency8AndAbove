package com.study.concurency.java8above.thread.threadgroup;

import java.util.Random;

public class ExceptionGenTask implements Runnable {

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		int result = 0;
		
		Random rd = new Random(Thread.currentThread().getId());
		int count = 1;
		while(true) {
			result = 1000/ ((int)rd.nextDouble() * 1000000000);
			
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf(" The thread %s is interreupted \n", Thread.currentThread().getId());
				return;
			}
		}
	}

}
