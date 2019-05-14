package com.study.concurency.java8above.thread.exceptionHandling;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has is captured in Thread : %s \n",t.getId());
		System.out.printf("Excetion : class = %s , message = %s \n",e.getClass(),e.getMessage());
		System.out.printf("Exception Stark trace \n",e.getClass(),e.getMessage());
		e.printStackTrace(System.out);
		System.out.printf("Thread status : %s \n", t.getState());
	}

}
