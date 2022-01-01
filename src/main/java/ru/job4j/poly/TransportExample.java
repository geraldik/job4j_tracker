package ru.job4j.poly;

public class TransportExample {
    public static void main(String[] args) {
        Vehicle airplane1 = new Airplane();
        Vehicle airplane2 = new Airplane();
        Vehicle airplane3 = new Airplane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle train3 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle bus3 = new Bus();
        Vehicle[] vehicles = new Vehicle[]{airplane1, airplane2, airplane3,
                train1, train2, train3,
                bus1, bus2, bus3};
        for (Vehicle v: vehicles) {
            v.move();
        }
    }
}
