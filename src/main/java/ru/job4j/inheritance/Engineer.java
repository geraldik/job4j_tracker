package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean isCanSolder;

    public Engineer(String name, String surname, String education, int birthday, boolean isCanSolder) {
        super(name, surname, education, birthday);
        this.isCanSolder = isCanSolder;
    }

    public void solveTheProblem() {
        System.out.println("The problem is solved.");
    }

    public boolean isCanSolder() {
        return isCanSolder;
    }
}
