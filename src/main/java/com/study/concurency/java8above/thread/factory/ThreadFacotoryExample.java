package com.study.concurency.java8above.thread.factory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class ThreadFacotoryExample implements ThreadFactory {

	private String name;
	private int counter;
	private List<String>stats;
	
	
	public ThreadFacotoryExample(String name) {
		this.name = name;
		this.counter = 0;
		this.stats = new ArrayList<String>();
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread th = new Thread(r, name + "-Thread_" + counter);
		counter++;
		
		stats.add(String.format(" Create thread %d with name %s on %s \n", th.getId(),th.getName(),LocalDateTime.now().toString()));
		
		return th;
	}

	public List<String> getStats() {
		return stats;
	}
}
