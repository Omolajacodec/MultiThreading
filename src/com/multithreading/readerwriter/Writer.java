package com.multithreading.readerwriter;


public class Writer implements Runnable {

	DatabaseWriterPref database;
	
	public Writer() {
	}
	
	public Writer(DatabaseWriterPref database) {
		this.database = database;
	}

	@Override
	public void run() {
		try {
			database.write();
			Thread.sleep(1999);
			database.write();
			database.write();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
