package com.study.concurency.java8above.threadsynchronization;

import static org.junit.Assert.*;

import org.junit.Test;

import com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock.ParkingCash;
import com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock.ParkingCashThreadSafe;
import com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock.ParkingSensor;
import com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock.ParkingSensorThreadSafe;
import com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock.ParkingStat;
import com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock.ParkingStatThreadSafe;

public class ThreadSynchronizationJunitTestCase {

	@Test
	public void testWithoutMethodAndBlockSynchronization() {
		ParkingCash pCash = new ParkingCash();
		ParkingStat pStat = new ParkingStat(pCash);
		int noOfSensors = Runtime.getRuntime().availableProcessors();
		System.out.printf(" Parking un thread safe simulation with no of sensors: %d \n ", noOfSensors);
		Thread[] thArr = new Thread[noOfSensors];
		
		for (int i = 0; i < noOfSensors; i++) {
			ParkingSensor pSonsor = new ParkingSensor(pStat);
			Thread simThread = new Thread(pSonsor);
			thArr[i] = simThread;
			simThread.start();
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
	
	@Test
	public void testWithMethodAndBlockSynchronization() {
		ParkingCashThreadSafe pCashThSafe = new ParkingCashThreadSafe();
		ParkingStatThreadSafe pStatThSafe = new ParkingStatThreadSafe(pCashThSafe);
		
		int noOfSensors = Runtime.getRuntime().availableProcessors();
		System.out.printf(" Parking simulation with no of sensors: %d \n ", noOfSensors);
//		int noOfSensors = 1;
		Thread[] thArr = new Thread[noOfSensors];
		
		for (int i = 0; i < noOfSensors; i++) {
			ParkingSensorThreadSafe pSonsorThSafe = new ParkingSensorThreadSafe(pStatThSafe);
			Thread simThread = new Thread(pSonsorThSafe);
			thArr[i] = simThread;
			simThread.start();
		}
		
		for (int i = 0; i < thArr.length; i++) {
			try {
				thArr[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf(" Total of cars: %d \n", pStatThSafe.getNoOfCars());
		System.out.printf(" Total of motorcycles: %d \n" , pStatThSafe.getNoOfMotorcycles()); 
		pCashThSafe.close();
	}

}
