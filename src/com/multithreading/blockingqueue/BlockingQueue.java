package com.multithreading.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

	private final int limit = 2;
	private Queue<Integer> database;

	private int size;

	public BlockingQueue() {
		this.database = new LinkedList<>();
		this.size = 0;
	}

	public synchronized void read() throws InterruptedException {
		if (size == 0) {
			System.out.println("Waiting to Read from data in database");
			wait();
		}

		System.out.println("Reading from database");
		System.out.println(database.poll());
		size--;
		notifyAll();
	}

	public synchronized void write() throws InterruptedException {

		if (size == limit) {
			System.out.println("Waiting to write to database");
			wait();
		}
		System.out.println("writing to database");
		database.add(2);
		size++;
		notifyAll();
	}
}
