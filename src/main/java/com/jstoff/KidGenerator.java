package com.jstoff;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class KidGenerator implements Runnable {

    private Halloween night;
    private int currentNumber;
    private final Logger log = Logger.getLogger(this.getClass());

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
                TimeUnit.SECONDS.sleep((long)(Math.random() * 3));
            } catch (InterruptedException iex) {
                log.error("Issue with generator, sleep", iex);
            }
        }
    }
}
