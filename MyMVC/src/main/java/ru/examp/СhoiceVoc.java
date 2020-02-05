package ru.examp;

import org.springframework.web.bind.annotation.ModelAttribute;

public class СhoiceVoc {
    private int numVoc;

    public Vocabulary createVoc (int numVoc){
        if (numVoc==1){
            return new VocFirst();
        } else if (numVoc==2) {
            return new VocSecond();
        } else {
            return null;
        }
    }

    public int getNumVoc() {
        return numVoc;
    }

    public void setNumVoc(int numVoc) {
        this.numVoc = numVoc;
    }
}
