package com.study.concurency.java8above.thread.factory;

import java.util.concurrent.TimeUnit;

public class RunnableTaskExample implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
