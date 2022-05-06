package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Veronika");
        student.setGroup("p15");
        student.setDate("06.04.2022");

        System.out.println("Студент " + student.getName() + " в группе " + student.getGroup() + " с " +student.getDate());
    }
}
