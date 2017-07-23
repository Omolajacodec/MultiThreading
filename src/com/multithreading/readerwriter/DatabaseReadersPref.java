package com.multithreading.readerwriter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class DatabaseReadersPref {

	private Queue<Integer> database;

	private Semaphore resource;
	private Semaphore readMutex;
	private int reader;

	public DatabaseReadersPref() {
		this.database = new LinkedList<>();
		resource = new Semaphore(1);
		readMutex = new Semaphore(1);
		this.reader = 0;
	}

	public void read() throws InterruptedException {

		readMutex.acquire();
		reader++;
		if (reader == 1) {
			resource.acquire();
		}
		readMutex.release();
		System.out.println("Reading from database");
		System.out.println(database.poll());
		readMutex.acquire();
		reader--;
		if (reader == 0) {
			resource.release();
		}
		readMutex.release();
	}

	public void write() throws InterruptedException {
		resource.acquire();
		System.out.println("writing to database");
		database.add(2);
		resource.release();
	}
}
