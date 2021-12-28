package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int experience;

    public Dentist(String name, String surname, String education, int birthday, boolean isHasCertificate, int experience) {
        super(name, surname, education, birthday, isHasCertificate);
        this.experience = experience;
    }

    public String appointment(Pacient pacient) {
        return "Appointment for " + pacient.getName() + "is created.";
    }

    public int getExperience() {
        return experience;
    }
}
