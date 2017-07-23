package com.multithreading.blockingqueue;

public class Writer implements Runnable {

	BlockingQueue database;
	
	public Writer() {
	}
	
	public Writer(BlockingQueue database) {
		this.database = database;
	}

	@Override
	public void run() {
		try {
			database.write();
			database.write();
			database.write();
			database.write();
			database.write();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
