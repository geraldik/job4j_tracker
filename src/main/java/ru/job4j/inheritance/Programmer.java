package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String grade;

    public Programmer(String name, String surname, String education, int birthday, boolean isCanSolder, String grade) {
        super(name, surname, education, birthday, isCanSolder);
        this.grade = grade;
    }

    public void fixTheBug(Bug bug) {
        System.out.println(bug.getTitle() + "is fixed.");
    }

    public String getGrade() {
        return grade;
    }
}
