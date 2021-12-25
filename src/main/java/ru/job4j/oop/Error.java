package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активна: " + active);
        System.out.println("Код состояния: " + status);
        System.out.println("Текст ошибки: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 400, "Bad request");
        Error error3 = new Error(true, 404, "Not found");
        Error error4 = new Error(false, 501, "Not implemented");
        Error error5 = new Error(true, 502, "Bad gateway");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
        error4.printInfo();
        error5.printInfo();
    }
}
