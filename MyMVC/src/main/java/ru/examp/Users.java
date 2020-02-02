package ru.examp;

public class Users {
    private String Name;
    private int age;

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Users(String name, int age) {
        Name = name;
        this.age = age;
    }

    public Users() {
    }
}
