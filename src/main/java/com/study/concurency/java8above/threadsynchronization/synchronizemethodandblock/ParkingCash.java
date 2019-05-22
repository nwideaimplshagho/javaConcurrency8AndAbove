package com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock;

public class ParkingCash {
	private static final int charge = 2;
	private int cash;
	
	public ParkingCash() {
		this.cash = 0;
	}
	
	public void vehiclePay() {
		this.cash += charge;
	}
	
	public void close() {
		System.out.printf(" Closing parking \n");
		long totalAmount = this.cash;
		this.cash = 0;
		System.out.printf(" Total amount of cash collected %d \n", totalAmount);
	}
}
