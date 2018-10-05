package dicV2;

import java.util.ArrayList;

public class ListWordSaved {

    static ArrayList<Word> listWordSaved = new ArrayList<>(100); // Dữ liệu đã lưu ở các lần search trước

    public boolean isMyWordsEmpty() {
        return listWordSaved.isEmpty();
    }

    public static int isInListWordSaved(String word_taget) {
        return BinarySearch.binarySearchWord(listWordSaved, word_taget);
    }

    public void delWord(Word w) {
        listWordSaved.remove(isInListWordSaved(w.getWord_taget()));
    }
}
