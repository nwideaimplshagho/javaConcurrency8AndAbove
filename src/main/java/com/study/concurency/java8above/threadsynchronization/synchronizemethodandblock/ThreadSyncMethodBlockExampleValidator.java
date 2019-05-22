package com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock;

public class ThreadSyncMethodBlockExampleValidator {

	public static void main(String[] args) {

		ParkingCash pCash = new ParkingCash();
		ParkingStat pStat = new ParkingStat(pCash);
		System.out.printf(" Parking simulation \n");
		int noOfSensors = Runtime.getRuntime().availableProcessors();
		
		Thread[] thArr = new Thread[noOfSensors];
		
		for (int i = 0; i < noOfSensors; i++) {
			ParkingSensor pSonsor = new ParkingSensor(pStat);
			Thread simThread = new Thread(pSonsor);
			thArr[i] = simThread;
			thArr[i].start();
		}
		
		for (int i = 0; i < thArr.length; i++) {
			try {
				thArr[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf(" Total of cars: %d \n", pStat.getNoOfCars());
		System.out.printf(" Total of motorcycles: %d \n" , pStat.getNoOfMotorcycles()); 
		pCash.close();
	

	}

}
