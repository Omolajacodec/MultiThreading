package com.multithreading.diningphilosopher;

public class Philosopher implements Runnable {

	private Object leftFork;
	private Object rightFork;

	public Philosopher(Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	private void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep((int) Math.random() * 100);
	}

	public void run() {
		try {
			while(true) {
			doAction(": Thinking");
				synchronized (leftFork) {
					doAction(": Picking up left fork");
					synchronized(rightFork){
						doAction(": Picking up right fork and eating");
						doAction(": Putting down right fork");
					}
					doAction(": Putting down left fork");
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
	}
}
