package com.jstoff;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HalloweenTest {
    Halloween halloween;
    @Before
    public void setup() {
        halloween = new Halloween();

        Riley riley = new Riley(halloween);
        KidGenerator genenerator = new KidGenerator(halloween);

        Thread threadRiley = new Thread(riley);
        Thread threadKidGenerator = new Thread(genenerator);
        threadKidGenerator.start();
        threadRiley.start();
    }

    @Test
    public void testForKidsPassingHouse() throws Exception {

        int size = 0;
        while(size < 10) {
            size = halloween.getKids().size();
        }

    }
    

}