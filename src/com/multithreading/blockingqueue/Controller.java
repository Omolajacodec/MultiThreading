package com.multithreading.blockingqueue;

public class Controller {

	public static void main(String[] args) {
		System.out.println("Testing Blocking Queue");
		BlockingQueue database = new BlockingQueue();
		Writer writer = new Writer(database);
		Reader reader = new Reader(database);
		
		Thread t1 = new Thread(writer);
		Thread t2 = new Thread(reader);
		
		t1.start();
		t2.start();
	}
}
