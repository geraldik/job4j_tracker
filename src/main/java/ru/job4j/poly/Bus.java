package ru.job4j.poly;

public class Bus implements Transport {

    private int numOfPas;
    private double price;

    @Override
    public void go() {
        System.out.println("Go!");
    }

    @Override
    public void passengers(int numOfPas) {
       this.numOfPas += numOfPas;
    }

    @Override
    public double fill(int volume) {
        return price * volume;
    }
}
