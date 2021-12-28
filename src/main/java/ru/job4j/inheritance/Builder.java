package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean isHasCar;

    public Builder(String name, String surname, String education, int birthday, boolean isCanSolder, boolean isHasCar) {
        super(name, surname, education, birthday, isCanSolder);
        this.isHasCar = isHasCar;

    }

    public void measure() {
        System.out.println("The measure is done.");
    }

    public boolean isHasCar() {
        return isHasCar;
    }
}
