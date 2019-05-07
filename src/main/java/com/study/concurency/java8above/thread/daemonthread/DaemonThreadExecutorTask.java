package com.study.concurency.java8above.thread.daemonthread;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DaemonThreadExecutorTask {
	public static void main(String[] args) {
		Deque<Event> eventQueue = new ConcurrentLinkedDeque<Event>();
		
		DateEventTask dte = new DateEventTask(eventQueue);
		System.out.printf(" Loop will run for %d \n", Runtime.getRuntime().availableProcessors());
		for(int i =0 ; i < Runtime.getRuntime().availableProcessors(); i++) {
			Thread th = new Thread(dte);
			th.start();
		}
		
		CleanerTask ct = new CleanerTask(eventQueue);
		ct.start();
	}

}
