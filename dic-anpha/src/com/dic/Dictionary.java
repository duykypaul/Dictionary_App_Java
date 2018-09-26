package com.dic;

import java.util.ArrayList;

public class Dictionary {

    static ArrayList<Word> listWord = new ArrayList<>(); // Lưu dữ liệu lấy từ CSDL
    static ArrayList<Word> recentWords = new ArrayList<>(100); // Lưu dữ liệu lịch sử người dùng
    static ArrayList<Word> myWords = new ArrayList<>(); // Dữ liệu đã lưu (gắn dấu *) ở các lần search trước

    public boolean isListWordEmpty() {
        return listWord.isEmpty();
    }

    public boolean isRecentWordsEmpty() {
        return recentWords.isEmpty();
    }

    public boolean isMyWordsEmpty() {
        return myWords.isEmpty();
    }

    public int isInList(String word_taget) {
        for (int i = 0; i < listWord.size(); i++) {
            if (listWord.get(i).getWord_taget().equals(word_taget)) {
                return i;
            }
        }
        return -1;
    }

    public int isInRecentWords(String word_taget) {
        for (int i = 0; i < recentWords.size(); i++) {
            if (recentWords.get(i).getWord_taget().equals(word_taget)) {
                return i;
            }
        }
        return (int) -1;
    }

    public int isInMyWords(String word_taget) {
        for (int i = 0; i < myWords.size(); i++) {
            if (myWords.get(i).getWord_taget().equals(word_taget)) {
                return i;
            }
        }
        return -1;
    }
}
