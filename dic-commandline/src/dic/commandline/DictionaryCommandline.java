package dic.commandline;

import java.util.*;

public class DictionaryCommandline {

    DictionaryManagement DicMana = new DictionaryManagement();
    Scanner sc = new Scanner(System.in);

    // Menu option
    public void run() {
        DicMana.insertFromFile();
        int option;
        do {
            System.out.println("---------------------------------");
            System.out.println("-------Từ điển Anh - Việt--------");
            System.out.println("----------Nhập lựa chọn----------");
            System.out.println("1. Tra từ");
            System.out.println("2. Tìm kiếm chính xác");
            System.out.println("3. Thêm từ");
            System.out.println("4. Sửa từ");
            System.out.println("5. Xóa từ");
            System.out.println("6. In tất cả các từ trong từ điển");
            System.out.println("7. Kết thúc");
            System.out.println("---------------------------------");
            
            option = sc.nextInt();

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

    public static void main(String[] args) {
        DictionaryCommandline dc = new DictionaryCommandline();
        dc.run();
    }
}
