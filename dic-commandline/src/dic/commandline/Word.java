package dic.commandline;

import java.util.*;

public class Word {

    private String word_taget;
    private String word_explain;
    private String pronunciation;

    public Word() {
    }

    public Word(String word_taget, String word_explain) {
        this.word_taget = word_taget;
        this.word_explain = word_explain;
    }

    public Word(String word_taget, String word_explain, String pronunciation) {
        this.word_taget = word_taget;
        this.word_explain = word_explain;
        this.pronunciation = pronunciation;
    }

    // Khởi tạo Word từ định dạng dòng trong 1 file (có dấu tab)
    public Word(String lineInFile) {
        this.word_taget = lineInFile.substring(0, lineInFile.indexOf("\t"));
        this.word_explain = lineInFile.substring(lineInFile.indexOf("\t") + 1);
    }

    public String getWord_taget() {
        return word_taget;
    }

    public void setWord_taget(String word_taget) {
        this.word_taget = word_taget;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public void printWord() {
        System.out.printf("%-20s%-20s\n", word_taget, word_explain);
    }
    
    public void printWordNewStyle() {
        System.out.printf("%-20s%-20s%-20s\n", word_taget, word_explain, pronunciation);
    }

    public int compareTo(String str) {
        return this.word_taget.compareTo(str);
    }

}

// Tạo class so sánh 2 Word
class WordComparator implements Comparator<Word> {

    @Override
    public int compare(Word w1, Word w2) {
        return w1.getWord_taget().compareTo(w2.getWord_taget());
    }
}
