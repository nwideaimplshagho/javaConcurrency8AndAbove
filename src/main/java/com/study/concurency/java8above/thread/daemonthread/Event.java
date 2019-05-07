package com.study.concurency.java8above.thread.daemonthread;

import java.time.LocalDateTime;

public class Event {
	
	private LocalDateTime eventTime;
	private String event;
	public LocalDateTime getEventTime() {
		return eventTime;
	}
	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
}
