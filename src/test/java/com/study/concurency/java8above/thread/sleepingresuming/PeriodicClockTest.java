package com.study.concurency.java8above.thread.sleepingresuming;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class PeriodicClockTest {

	@Test
	public void testSleepAndResume() {
		Thread clockTask = new Thread(new PeriodicClock());
		clockTask.start();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clockTask.interrupt();
	}

}
