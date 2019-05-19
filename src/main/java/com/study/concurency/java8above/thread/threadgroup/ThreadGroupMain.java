package com.study.concurency.java8above.thread.threadgroup;

public class ThreadGroupMain {
	
	public static void main(String[] args) {

		int numOfThread = (Runtime.getRuntime().availableProcessors());
		ThreadGroupLocalExamples thGrp = new ThreadGroupLocalExamples("Example ThreadGroup");
		ExceptionGenTask task = new ExceptionGenTask();
		for (int i = 0; i < numOfThread; i++) {
			Thread th = new Thread(thGrp, task);
			th.start();
		}
		
		System.out.printf("Number of threads : %d \n",thGrp.activeCount());
		System.out.printf("Information about thread group \n");
		thGrp.list();
		
		Thread[] threads = new Thread[thGrp.activeCount()];
		thGrp.enumerate(threads);
		for (int i = 0; i < threads.length; i++) {
			System.out.printf(" Thread :%s | status : %s \n", threads[i].getId(),threads[i].getState());
		}
	}
}
