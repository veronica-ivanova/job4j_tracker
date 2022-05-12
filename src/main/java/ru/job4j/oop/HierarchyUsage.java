package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();

        Transport tp = car;

        Object obj = car;

        Object ocar = new Car();

        /* Приведение типа за счет понижения по иерархии. */
        Car carFromObject = (Car) ocar;


    }
}
