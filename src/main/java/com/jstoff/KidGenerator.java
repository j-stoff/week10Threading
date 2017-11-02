package com.jstoff;

import java.util.concurrent.TimeUnit;

public class KidGenerator implements Runnable {

    private Halloween night;
    private int currentNumber;

    public KidGenerator() {
        super();
    }

    public KidGenerator(Halloween halloween) {
        this();
        night = halloween;
        currentNumber = 1;
    }

    public void run() {
        while (true) {
            Child child = new Child(currentNumber, night);
            currentNumber += 1;
            Thread threadChild = new Thread(child);
            threadChild.start();

            try {
                TimeUnit.SECONDS.sleep((long)(Math.random() * 5));
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
    }
}
