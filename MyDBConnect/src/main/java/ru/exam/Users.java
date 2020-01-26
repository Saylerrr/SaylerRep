package ru.exam;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String user;

    public Users(){
    }

    public Users(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", user='" + user + '\'' +
                '}';
    }
}

