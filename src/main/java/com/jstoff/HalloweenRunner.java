package com.jstoff;

public class HalloweenRunner {

    public static void main(String args[]) {
        Halloween halloween = new Halloween();

        Riley riley = new Riley(halloween);
        KidGenerator genenerator = new KidGenerator(halloween);

        Thread threadRiley = new Thread(riley);
        Thread threadKidGenerator = new Thread(genenerator);
        threadKidGenerator.start();
        threadRiley.start();
    }
}
