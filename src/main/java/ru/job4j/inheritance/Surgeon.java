package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String specialties;

    public Surgeon(String name, String surname, String education, int birthday, boolean isHasCertificate, String specialties) {
        super(name, surname, education, birthday, isHasCertificate);
        this.specialties = specialties;
    }

    public String operability(Pacient pacient) {
        return "Pacient " + pacient.getName() + " is operable.";
    }

    public String getSpecialties() {
        return specialties;
    }
}
