package ru.examp;

import javax.persistence.*;

@Entity
@Table(name = "voc_second")
public class VocSecond implements Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String word_first;

    private String word_second;

    public VocSecond(String word_first, String word_second) {
        this.word_first = word_first;
        this.word_second = word_second;
    }

    public VocSecond() {
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
}
