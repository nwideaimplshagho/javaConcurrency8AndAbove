package com.study.concurency.java8above.thread.exceptionHandling;

import org.junit.Test;

public class RunnableTaskExceptionGeneratorTest {

	@Test
	public void testThreadExceptionhandler() {
		Runnable excepGenTask = new RunnableTaskExceptionGenerator();
		Thread excepGenThread = new Thread(excepGenTask);
		excepGenThread.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		excepGenThread.start();
		try {
			excepGenThread.join();
		} catch (Exception e) {
			System.out.println("Printing exceptionm stack trace");
			e.printStackTrace(System.out);
		}
		
		System.out.printf("Completed execution of Test class : %s ", RunnableTaskExceptionGeneratorTest.class);
		
	}

}
