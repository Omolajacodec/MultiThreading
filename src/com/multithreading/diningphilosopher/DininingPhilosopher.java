package com.multithreading.diningphilosopher;

public class DininingPhilosopher {

	public static void main(String[] args) {
		int TOTAL_PHILOSOPHERS = 5;
		Philosopher[] philosophers = new Philosopher[TOTAL_PHILOSOPHERS];
		Object[] forks = new Object[TOTAL_PHILOSOPHERS];

		for (int i = 0; i < TOTAL_PHILOSOPHERS; i++) {
			forks[i] = new Object();
		}

		for (int i = 0; i < TOTAL_PHILOSOPHERS; i++) {
			Object leftFork = forks[i];
			Object rightFork = forks[(i + 1) % TOTAL_PHILOSOPHERS];
			if (i == philosophers.length - 1) {
				philosophers[i] = new Philosopher(rightFork, leftFork);
			} else {
				philosophers[i] = new Philosopher(leftFork, rightFork);
			}

			Thread t = new Thread(philosophers[i], "  " + i);
			t.start();
		}

	}

}
