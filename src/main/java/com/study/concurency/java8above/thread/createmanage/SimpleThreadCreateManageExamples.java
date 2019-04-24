package com.study.concurency.java8above.thread.createmanage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class SimpleThreadCreateManageExamples {

	public static void main(String[] args) {
		System.out.printf("Max thread pririty : %d \n", Thread.MAX_PRIORITY);
		System.out.printf("Min thread pririty : %d \n", Thread.MIN_PRIORITY);
		System.out.printf("Normal thread pririty : %d \n", Thread.NORM_PRIORITY);
		
		Thread[] threads = new Thread[5];
		Thread.State[] statuses = new Thread.State[5];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new PrimeCalculator());
			if (i%2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			
			threads[i].setName("Thread" +i);
		}
		
		try(FileWriter fw = new FileWriter(".\\data\\log.txt");PrintWriter pw = new PrintWriter(fw)) {
			
			for (int i = 0; i < threads.length; i++) {
				statuses[i] = threads[i].getState();
				pw.printf("Status of thread %s \n",statuses[i].name());
			}
			
			for (int i = 0; i < threads.length; i++) {
				threads[i].start();
			}
			
			boolean isFinalization = false;
			while(!isFinalization) {
				for (int i = 0; i < threads.length; i++) {
					if (threads[i].getState().compareTo(statuses[i]) != 0) {
						writeToFile(pw, threads[i], statuses[i]);
					}
				}
				
				isFinalization = true;
				for (int i = 0; i < statuses.length; i++) {
					isFinalization = isFinalization && (threads[i].getState() == statuses[i]);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	private static void writeToFile(PrintWriter pw, Thread th, State st) {
		pw.printf(" Id %d - Name %s \n" , th.getId(),th.getName());
		pw.printf(" Priority - %d \n", th.getPriority());
		pw.printf(" Old state - %s \n", st);
		pw.printf(" New state - %s \n" , th.getState());
		pw.printf(" ************************************ ");
	}
}
