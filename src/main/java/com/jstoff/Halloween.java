package com.jstoff;


import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Halloween {

    private List<Child> kids;
    private int maxAtDoor;

    public Halloween() {
        maxAtDoor = 10;
        kids = new LinkedList<Child>();
    }


    public void startNight() {
        Child currentChild;
        System.out.println("Waiting for locks??");
        synchronized (kids) {
            while (kids.size() == 0) {
                System.out.println("Riley is watching TV");
                try {
                    kids.wait();
                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }

            System.out.println("Riley answered the door");
            currentChild = (Child)((LinkedList<Child>)kids).poll();
        }

        try {
            System.out.println("Riley is handing out candy to " + currentChild.getNumber());
            sleep(3000);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
    }

    public void add(Child toAdd) {
        synchronized (kids) {
            if (kids.size() == 10) {
                System.out.println("House is busy " + toAdd.getNumber() + " child left");
                return;
            }

            ((LinkedList<Child>)kids).offer(toAdd);
            System.out.println("Child: " + toAdd.getNumber() + " is at the door");

            if (kids.size() == 1) {
                kids.notify();
            }
        }
    }
}
