package com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock;

public class ParkingStatThreadSafe {
	private int noOfCars;
	private int noOfMotorcycles;
	private Object carController,motorcycleController;
	private ParkingCashThreadSafe pCashThSafe;
	
	public ParkingStatThreadSafe(ParkingCashThreadSafe pCash) {
		this.pCashThSafe = pCash;
		this.noOfCars = 0;
		this.noOfMotorcycles = 0;
		this.carController = new Object();
		this.motorcycleController = new Object();
	}

	public void carIn() {
		synchronized (this.carController) {
			this.noOfCars++;
		}
	}
	
	public void motorcycleIn() {
		synchronized (this.motorcycleController) {
			this.noOfMotorcycles++;
		}
	}
	
	public void motorcycleGoOut() {
		synchronized (this.motorcycleController) {
			this.noOfMotorcycles--;
		}
		this.pCashThSafe.vehiclePay();
	}

	public void carGoOut() {
		synchronized (this.carController) {
			this.noOfCars--;	
		}
		this.pCashThSafe.vehiclePay();
	}

	public int getNoOfCars() {
		synchronized (this.carController) {
			return this.noOfCars;	
		}
	}

	public int getNoOfMotorcycles() {
		synchronized (this.motorcycleController) {
			return this.noOfMotorcycles;
		}
	}
}
