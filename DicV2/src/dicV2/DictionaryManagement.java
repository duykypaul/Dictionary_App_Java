package dicV2;

import java.util.ArrayList;

public class DictionaryManagement {
    FileProcessing FP = new FileProcessing();
    SQLProcessing SP = new SQLProcessing();
    Dictionary dic = new Dictionary();
    ListWordSaved wordSaved = new ListWordSaved();
    ListWordHistory wordHistory = new ListWordHistory();

    public boolean initData() {
        FP.updateListSaved(); 
        FP.updateListHistory();
        FP.updateFileDic();
        return SP.dictionaryImportfromSQL();
    }
    
    public void updateDataBeforeClosing() {
        FP.updateFileSaved();
        FP.updateFileHistory();
    }
    
    public boolean addWordToDictionary(Word w) {
        if(dic.insertToList(w)) {
            SP.insertToSQL(w);
            return true;
        }
        return false;
    }
    
    public boolean editWordInDictionary(Word oldWord, Word newWord) {
        if(dic.editWordInList(oldWord, newWord)) {
            SP.editWordInSQL(oldWord, newWord);
            return true;
        } else {
            return false;
        }
    }
    
    public void deleteWordInDictionary(Word w) {
        dic.deleteInList(w);
        SP.deleteInSQL(w);
    }
    
    public void deleteWordInSaved(Word w) {
        wordSaved.delWord(w);
    }
    
    public boolean saveWord(Word w) {
        return dic.addWordToSavedWord(w);
    }
    
    public void addToHistory(Word w) {
        dic.addToHistory(w);
    }
    
    public ArrayList<Word> createListSearched(ArrayList<Word> listWord, String search_str) {
        ArrayList<Word> listTaget = BinarySearch.searchSmart(listWord, search_str);
        return listTaget;
    }
}
