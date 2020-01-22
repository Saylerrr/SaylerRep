package org.example;

public class ClassRoom {
    private Student stud;
    public ClassRoom(Student stud){
        this.stud=stud;
    }
    public void studDo(){
        stud.writeLecture();
    }
}
