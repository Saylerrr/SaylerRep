package org.example;

public class StudentJone implements Student {
    @Override
    public void writeLecture(){
        System.out.println("Записал не всю лекцию");
    }
}
