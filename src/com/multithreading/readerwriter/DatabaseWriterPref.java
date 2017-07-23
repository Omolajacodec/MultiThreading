package com.multithreading.readerwriter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class DatabaseWriterPref {

	private Queue<Integer> database;

	private Semaphore readerLock, writerLock, resourceLock, readTryLock;

	private int writer, reader;

	public DatabaseWriterPref() {
		this.database = new LinkedList<>();
		this.readerLock = new Semaphore(1);
		this.writerLock = new Semaphore(1);
		this.resourceLock = new Semaphore(1);
		this.readTryLock = new Semaphore(1);
		this.writer = 0;
		this.reader = 0;
	}

	public void read() throws InterruptedException {
		readTryLock.acquire();
		readerLock.acquire();
		reader++;
		if (reader == 1) {
			resourceLock.acquire();
		}
		readerLock.release();
		readTryLock.release();
		System.out.println("Reading from database");
		System.out.println(database.poll());
		readerLock.acquire();
		reader--;
		if (reader == 0) {
			resourceLock.release();
		}
		readerLock.release();
	}

	public void write() throws InterruptedException {
		writerLock.acquire();
		writer++;
		if (writer == 1) {
			readTryLock.acquire();
		}
		writerLock.release();
		resourceLock.acquire();
		System.out.println("Writing to database");
		database.add(2);
		resourceLock.release();
		writerLock.acquire();
		writer--;
		if (writer == 0) {
			readTryLock.release();
		}
		writerLock.release();
	}

}
