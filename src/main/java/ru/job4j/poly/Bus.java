package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("поехали");

    }

    @Override
    public void passengers(int x) {
        System.out.println("В автобусе" + x + "пассажиров");

    }

    @Override
    public int refuel(int gas) {
        return gas * 50;
    }
}
