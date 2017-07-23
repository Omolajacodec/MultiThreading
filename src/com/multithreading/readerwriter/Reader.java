package com.multithreading.readerwriter;


public class Reader implements Runnable{

	DatabaseWriterPref database;
	
	public Reader() {
	}
	
	public Reader(DatabaseWriterPref database) {
		this.database = database;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			database.read();
			database.read();
			database.read();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
