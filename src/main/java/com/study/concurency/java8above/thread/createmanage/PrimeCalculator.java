package com.study.concurency.java8above.thread.createmanage;

public class PrimeCalculator implements Runnable {

	public void run() {
		long currentNum = 1l;
		long maxNum = 20000l;
		long primeCount = 0l;
		
		System.out.printf(" Thread '%s' : Start \n",Thread.currentThread().getName());
		while(currentNum <= maxNum) {
			if (isPrime(currentNum)) {
				primeCount++;
			}
			currentNum++;
		}
		
		System.out.printf(" Thread '%s' : End prime number count %d \n",Thread.currentThread().getName(),primeCount);
	}
	
	private boolean isPrime(long num) {
		boolean isPrime = true;
		if (num <= 2) {
			return isPrime;
		}
		
		for (int i = 2; i < num; i++) {
			if ((num%i) == 0) {
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}
	
	

}
