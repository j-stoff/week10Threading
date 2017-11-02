package com.jstoff;


import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Halloween {

    private List<Child> kids;
    private int maxAtDoor;
    private final Logger log = Logger.getLogger(this.getClass());

    public Halloween() {
        maxAtDoor = 10;
        kids = new LinkedList<Child>();
    }


    public void startNight() {
        Child currentChild;
        log.info("Waiting for kids to come to the door.");
        synchronized (kids) {
            while (kids.size() == 0) {
                log.info("Riley is watching TV");
                try {
                    kids.wait();
                } catch (InterruptedException iex) {
                    log.error("Thread interrupted in start night, no kids", iex);
                }
            }

            log.info("Riley answered the door");
            currentChild = (Child)((LinkedList<Child>)kids).poll();
        }

        try {
            log.info("Riley is handing out candy to " + currentChild.getNumber());
            sleep(3000);
        } catch (InterruptedException iex) {
            log.error("Thread interruption in startNight, while giving candy", iex);
        }
    }

    public void add(Child toAdd) {
        synchronized (kids) {
            if (kids.size() >= 10) {
                log.info("House is busy " + toAdd.getNumber() + " child left");
                return;
            }

            ((LinkedList<Child>)kids).offer(toAdd);
            log.info("Child: " + toAdd.getNumber() + " is at the door");

            if (kids.size() == 1) {
                kids.notify();
            }
        }
    }

    public synchronized List<Child> getKids() {
        return kids;
    }
}
