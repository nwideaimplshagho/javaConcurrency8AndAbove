package com.study.concurency.java8above.thread.exceptionHandling;

public class RunnableTaskExceptionGenerator implements Runnable {

	@Override
	public void run() {
		int number = Integer.parseInt("ABCD");
		System.out.printf("Number is : %d \n" + number);
	}

}
