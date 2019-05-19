package com.study.concurency.java8above.thread.threadgroup;

public class ThreadGroupLocalExamples extends ThreadGroup {

	public ThreadGroupLocalExamples(String name) {
		super(name);
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf(" Exception generated in thread : %s \n ", t.getId());
		e.printStackTrace(System.out);
		System.out.printf(" Terminting rest of threads \n");
		interrupt();
	}

}
