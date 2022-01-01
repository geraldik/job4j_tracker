package ru.job4j.poly;

public interface Transport {
    public void go();

    public void passengers(int numOfPas);

    public double fill(int volume);
}
