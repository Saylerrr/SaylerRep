package ru.examp;

import javax.persistence.*;

@Entity
@Table(name = "voc_first")
public class VocFirst implements Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String word_first;

    @Column
    private String word_second;

    public VocFirst(String word_first, String word_second) {
        this.word_first = word_first;
        this.word_second = word_second;
    }

    public VocFirst() {
    }

    public int getId() {
        return id;
    }

    public String getWord_first() {
        return word_first;
    }

    public String getWord_second() {
        return word_second;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWord_first(String word_first) {
        this.word_first = word_first;
    }

    public void setWord_second(String word_second) {
        this.word_second = word_second;
    }

    @Override
    public String toString() {
        return "VocFirst{" +
                "id=" + id +
                ", word_first='" + word_first + '\'' +
                ", word_second='" + word_second + '\'' +
                '}';
    }
}
