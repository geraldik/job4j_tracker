package ru.job4j.inheritance;

public class Diagnosis {

    private String value;

    public Diagnosis(String name) {
        this.value = diagnostics(name);
    }

    public String diagnostics(String name) {
        return name + "is diagnosed";
    }
}
