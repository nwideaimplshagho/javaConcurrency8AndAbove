package com.study.concurency.java8above.threadsynchronization.synchronizemethodandblock;

public class ParkingStat {
	private int noOfCars;
	private int noOfMotorcycles;
	private ParkingCash pCash;
	
	public ParkingStat(ParkingCash pCash) {
		this.pCash = pCash;
		this.noOfCars = 0;
		this.noOfMotorcycles = 0;
	}

	public void carIn() {
		this.noOfCars++;
	}
	
	public void motorcycleIn() {
		this.noOfMotorcycles++;
	}
	
	public void motorcycleGoOut() {
		this.noOfMotorcycles--;
		this.pCash.vehiclePay();
	}

	public void carGoOut() {
		this.noOfCars--;
		this.pCash.vehiclePay();
	}

	public int getNoOfCars() {
		return noOfCars;
	}

	public int getNoOfMotorcycles() {
		return noOfMotorcycles;
	}
}
