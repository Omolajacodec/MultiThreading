package com.multithreading.readerwriter;

public class ReaderWriterController {
	public static void main(String[] args) {
		System.out.println("Testing Blocking Queue");
		DatabaseWriterPref database = new DatabaseWriterPref();
		Writer writer = new Writer(database);
		Reader reader = new Reader(database);

		Thread t1 = new Thread(writer);
		Thread t2 = new Thread(reader);

		t1.start();
		t2.start();
	}
}
