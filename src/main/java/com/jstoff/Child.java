package com.jstoff;

public class Child implements Runnable {
    private Halloween night;
    private int numberInLine;

    public Child() {
        super();
    }

    public Child(Halloween night) {
        this.night = night;
    }

    public Child(int childNumber, Halloween theNight) {
        super();
        System.out.println("Child number " + childNumber + " was created");
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
