package ru.job4j.tracker.oop;

public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("Ball is eaten");
        } else {
            System.out.println("Ball escaped");
        }
    }
}
