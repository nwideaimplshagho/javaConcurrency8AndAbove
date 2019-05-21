package com.study.concurency.java8above.thread.factory;

import org.junit.Test;

public class ThreadManagementExamples {

	@Test
	public void testThreadCreationByThreadFactory() {
		ThreadFacotoryExample thEx = new ThreadFacotoryExample("MyThreadFactoryEx");
		RunnableTaskExample runTaskEx = new RunnableTaskExample();
		
		System.out.printf(" Starting threads \n");
		for (int i = 0; i < (Runtime.getRuntime().availableProcessors() * 2); i++) {
			Thread newThread = thEx.newThread(runTaskEx);
			newThread.start();
		}
		
		System.out.printf(" Thread factory stats \n");
		System.out.printf(" %s \n", thEx.getStats());
	}
}
