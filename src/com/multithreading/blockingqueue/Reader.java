package com.multithreading.blockingqueue;

public class Reader implements Runnable{

	BlockingQueue database;
	
	public Reader() {
	}
	
	public Reader(BlockingQueue database) {
		this.database = database;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			database.read();
			database.read();
			database.read();
			Thread.sleep(1000);
			database.read();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
