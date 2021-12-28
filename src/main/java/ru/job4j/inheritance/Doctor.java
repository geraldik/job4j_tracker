package ru.job4j.inheritance;

public class Doctor extends Profession {

    private boolean isHasCertificate;

    public Doctor(String name, String surname, String education, int birthday, boolean isHasCertificate) {
        super(name, surname, education, birthday);
        this.isHasCertificate = isHasCertificate;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis(pacient.getName());
    }

    public boolean isHasCertificate() {
        return isHasCertificate;
    }
}


