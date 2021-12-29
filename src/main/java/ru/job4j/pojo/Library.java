package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bk1 = new Book("Effective Java", 466);
        Book bk2 = new Book("Philosophy of Java", 1170);
        Book bk3 = new Book("The Complete Reference Java", 1500);
        Book bk4 = new Book("Clean code", 431);
        Book[] books = new Book[4];
        books[0] = bk1;
        books[1] = bk2;
        books[2] = bk3;
        books[3] = bk4;

        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getNumOfPages() + " p.");
        }

        new Book("", 0);
        Book temp;
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getNumOfPages() + " p.");
        }

        for (Book bk : books) {
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getNumOfPages() + " p.");
            }
        }

    }
}
