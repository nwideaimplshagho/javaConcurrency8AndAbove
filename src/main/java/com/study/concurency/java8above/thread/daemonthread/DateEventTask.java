package com.study.concurency.java8above.thread.daemonthread;

import java.time.LocalDateTime;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class DateEventTask implements Runnable {

	private Deque<Event> eventQueue;
	
	public DateEventTask(Deque<Event> eventQueue) {
		this.eventQueue = eventQueue;
	}
	
	@Override
	public void run() {
		for(int i =0 ; i < 100; i++) {
			Event ev = new Event();
			ev.setEventTime(LocalDateTime.now());
			ev.setEvent(String.format(" Thread %s has generated event %d event ", Thread.currentThread().getName(),i));
			
			eventQueue.add(ev);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
