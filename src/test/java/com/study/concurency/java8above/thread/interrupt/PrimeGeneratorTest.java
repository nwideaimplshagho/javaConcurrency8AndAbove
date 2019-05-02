package com.study.concurency.java8above.thread.interrupt;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

public class PrimeGeneratorTest {

	private static PrimeGenerator primeGenTask;
	
	@BeforeClass
	public static void setUp() {
		primeGenTask = new PrimeGenerator();
	}
	
	@Test
	public void testPrimeGeneratorInterupted() {
		primeGenTask.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		primeGenTask.interrupt();
		
		System.out.printf(" PrimeGeneratorTest : Thread = %s state is = %s \n",primeGenTask.getName(),primeGenTask.getState());
		System.out.printf(" PrimeGeneratorTest : Thread = %s is interrupted %s \n",primeGenTask.getName(),primeGenTask.isInterrupted());
		System.out.printf(" PrimeGeneratorTest : Thread = %s is alive %s \n",primeGenTask.getName(),primeGenTask.isInterrupted());
	}

}
