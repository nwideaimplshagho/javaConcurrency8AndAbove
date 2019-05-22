package com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock;

import java.util.concurrent.TimeUnit;

public class ParkingSensorThreadSafe implements Runnable{


	private ParkingStatThreadSafe pStatThreadSafe;
	
	public ParkingSensorThreadSafe(ParkingStatThreadSafe pStatThreadSafe) {
		this.pStatThreadSafe = pStatThreadSafe;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			pStatThreadSafe.carIn();
			pStatThreadSafe.motorcycleIn();
			
			try {
				TimeUnit.MICROSECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			pStatThreadSafe.carGoOut();
			try {
				TimeUnit.MICROSECONDS.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pStatThreadSafe.motorcycleGoOut();
			
			try {
				TimeUnit.MICROSECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pStatThreadSafe.carIn();
			pStatThreadSafe.motorcycleIn();;
			
		}
	}
}
