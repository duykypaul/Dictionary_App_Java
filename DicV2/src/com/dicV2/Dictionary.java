package com.dicV2;

import java.util.ArrayList;

public class Dictionary {

    static ArrayList<Word> listWord = new ArrayList<>(); // Lưu dữ liệu lấy từ CSDL

    public boolean isListWordEmpty() {
        return listWord.isEmpty();
    }
    
    public static int isInDic(String word_taget) {
        return BinarySearch.binarySearchWord(listWord,word_taget);
    }

    public void addToHistory(Word w) {
        if (ListWordHistory.isInListWordHistory(w.getWord_taget()) == -1) {
            if (ListWordHistory.listWordHistory.size() >= 100) {
               ListWordHistory.listWordHistory.remove(99);
            }
            ListWordHistory.listWordHistory.add(0, w);
        }
    } 
    
    public boolean addWordToSavedWord(Word w) {
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
    
    // Thêm 1 từ vào listWord
    public boolean insertToList(Word w) {
        int pos = BinarySearch.posInsertWord(listWord,w.getWord_taget());
        if(pos != -1) {
            if(pos == listWord.size()) {
                listWord.add(w);
            } else {
                listWord.add(pos, w);
            }
            return true;
        }
        return false;
    }
    
    // Xóa 1 từ từ listWord
    public void deleteInList(Word w) {
        Dictionary.listWord.remove(Dictionary.isInDic(w.getWord_taget()));
    }
    
    // Sửa một từ từ listWord
    public boolean editWordInList(Word oldWord, Word newWord) {
        if(isInDic(newWord.getWord_taget()) == -1) {
            deleteInList(oldWord);
            insertToList(newWord);
            return true;
        }
        return false;
    }
}
