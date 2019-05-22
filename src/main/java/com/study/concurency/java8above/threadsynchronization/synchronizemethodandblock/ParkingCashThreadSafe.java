package com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock;

public class ParkingCashThreadSafe {
	private static final int charge = 2;
	private int cash;
	
	public ParkingCashThreadSafe() {
		this.cash = 0;
	}
	
	public synchronized void vehiclePay() {
		this.cash += charge;
	}
	
	public void close() {
		System.out.printf(" Closing parking \n");
		long totalAmount = 0;

		synchronized (this) {
			totalAmount = this.cash;
			this.cash = 0;
		}
		System.out.printf(" Total amount of cash collected %d \n", totalAmount);
	}
}
