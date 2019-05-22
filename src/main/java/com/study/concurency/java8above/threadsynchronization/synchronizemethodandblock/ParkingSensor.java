package com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock;

import java.util.concurrent.TimeUnit;

public class ParkingSensor implements Runnable {

	private ParkingStat pStat;
	
	public ParkingSensor(ParkingStat pStat) {
		this.pStat = pStat;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			pStat.carIn();
			pStat.motorcycleIn();
			
			try {
				TimeUnit.MICROSECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			pStat.carGoOut();
			try {
				TimeUnit.MICROSECONDS.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pStat.motorcycleGoOut();
			
			try {
				TimeUnit.MICROSECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			pStat.carIn();
//			pStat.motorcycleIn();
			
		}
	}

}
