package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student st = new Student();
        st.setFio("Петров Петр Петрович");
        st.setGroup("Э5-2");
        st.setReceiptDate("20.07.2020");
        String s = System.lineSeparator();
        System.out.println("Студент: " + st.getFio() + s + "Группа: "
                + st.getGroup() + s + "Дата поступления: " + st.getReceiptDate());
    }
}
