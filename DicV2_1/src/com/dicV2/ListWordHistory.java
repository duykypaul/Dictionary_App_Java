package com.dicV2;

import java.util.ArrayList;

public class ListWordHistory {

    static ArrayList<Word> listWordHistory = new ArrayList<>(100); // Lưu dữ liệu lịch sử người dùng

    public boolean isRecentWordsEmpty() {
        return listWordHistory.isEmpty();
    }

    public static int isInListWordHistory(String word_taget) {
        for (int i = 0; i < listWordHistory.size(); i++) {
            if (listWordHistory.get(i).getWord_taget().equals(word_taget)) {
                return i;
            }
        }
        return (int) -1;
    }
    
    public boolean saveWord(Word w) {
        if (ListWordSaved.isInListWordSaved(w.getWord_taget()) != -1) {
            return false;
        } else {
            if (ListWordSaved.listWordSaved.size() >= 100) {
               ListWordSaved.listWordSaved.remove(99);
            }
            ListWordSaved.listWordSaved.add(0, w);
            return true;
        }
    }

}
