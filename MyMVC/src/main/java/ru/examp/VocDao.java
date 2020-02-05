package ru.examp;

import java.util.List;

public interface VocDao {
    List<VocFirst> getVocList(String key);
    boolean setWord(String key, String word);
    List<VocFirst> getAllVoc();
    VocFirst getId(int id);
}
