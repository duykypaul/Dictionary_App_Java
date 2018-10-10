package dic.commandline;

import java.io.IOException;
import java.util.*;

public class DictionaryCommandline {

    static DictionaryManagement DicMana = new DictionaryManagement();
    static Scanner sc = new Scanner(System.in);
    
    // Xóa màn hình
    public void CLS() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    
    // Menu option
    public void run() throws IOException, InterruptedException {
        DicMana.insertFromFile();
        int option;
        do {
            System.out.println("----------------------------------");
            System.out.println("------ DICTIONARY EN <-> VI ------");
            System.out.println("---------------Option-------------");
            System.out.println("1. Searcher");
            System.out.println("2. Lookup");
            System.out.println("3. Add");
            System.out.println("4. Edit");
            System.out.println("5. Delete");
            System.out.println("6. Show All");
            System.out.println("7. End");
            System.out.println("---------------------------------");

            option = sc.nextInt();
            CLS();

            switch (option) {
                case 1:
                    DicMana.dictionarySearcher();
                    break;
                case 2:
                    DicMana.dictionaryLookup();
                    break;
                case 3:
                    DicMana.insertFromCommandline();
                    break;
                case 4:
                    DicMana.editWordInDic();
                    break;
                case 5:
                    DicMana.deleteWordInDic();
                    break;
                case 6:
                    DicMana.showAllWords();
                    break;
            }
        } while (option >= 1 && option <= 6);
        DicMana.dictionaryExportToFile();
    }
}
