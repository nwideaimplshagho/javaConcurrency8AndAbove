package com.study.concurency.java8above.thread.daemonthread;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Deque;

public class CleanerTask extends Thread {

	private Deque<Event> eventQueue;
	
	public CleanerTask(Deque<Event> eventQueue) {
		this.eventQueue = eventQueue;
		this.setDaemon(true);
	}
	
	@Override
	public void run() {
		boolean isDelete = false;
		long eventTimeDiff =0;
		
		if (this.eventQueue.isEmpty()) {
			return;
		}
		
		do {
			Event ev = eventQueue.getLast();
			eventTimeDiff = LocalDateTime.now().getLong(ChronoField.SECOND_OF_DAY) - ev.getEventTime().getLong(ChronoField.SECOND_OF_DAY);
			
			if (eventTimeDiff > 10000) {
				System.out.printf(" CleanerTask : %s \n", ev.getEvent());
				isDelete = true;
				eventQueue.removeLast();
			}
		}while(eventTimeDiff > 10000);
		
		if (isDelete) {
			System.out.printf(" CleanerTaslk : event queue size after cleaning %s ", eventQueue.size());
		}
	}
	
}
