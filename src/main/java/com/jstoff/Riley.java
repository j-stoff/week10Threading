package com.jstoff;

import java.util.List;

public class Riley implements Runnable {

    private Halloween halloween;

    public Riley() {
        super();
    }

    public Riley(Halloween night) {
        super();
        halloween = night;
    }

    public void run() {
        while(true) {
            halloween.startNight();
        }
    }



}
