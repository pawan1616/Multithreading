package com.interview.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOdd {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private int even = 0;
    private int odd = 1;
    int max = 0;
    private boolean printEven = true;

    private void printEven() {
        while (max < 50) {
            try {
                lock.lock();
                while (!printEven) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                printEven = false;
                System.out.println("Even number is: " + even);
                even += 2;
                condition.signalAll();
                max++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void printOdd() {
        while (max < 50) {
            try {
                lock.lock();
                while (printEven) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                printEven = true;
                System.out.println("odd number is: " + odd);
                odd += 2;
                condition.signalAll();
                max++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EvenOdd evenOdd = new EvenOdd();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> evenOdd.printEven());
        executor.submit(() -> evenOdd.printOdd());

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
