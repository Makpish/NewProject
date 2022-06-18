package models;


import java.util.Random;

public class Dice {

    private final Random random = new Random();
    private int sides;

    public Dice() {
        this.sides = 6;
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
