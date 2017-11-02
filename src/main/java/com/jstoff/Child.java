package com.jstoff;

import org.apache.log4j.Logger;

public class Child implements Runnable {
    private Halloween night;
    private int numberInLine;
    private final Logger log = Logger.getLogger(this.getClass());

    public Child() {
        super();
    }

    public Child(Halloween night) {
        this.night = night;
    }

    public Child(int childNumber, Halloween theNight) {
        super();
        log.info("Child number " + childNumber + " was created");
        night = theNight;
        numberInLine = childNumber;
    }

    public int getNumber() {
        return numberInLine;
    }

    public void run() {
        ringDoorBell();
    }

    public synchronized void ringDoorBell() {
        night.add(this);
    }
}
