package dic.commandline;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {

    private final Scanner  sc = new Scanner (new InputStreamReader(System.in,Charset.forName("UTF-8") ));
    private static final String fileName = "dictionaries.txt";

    public void showAllWords() {
        if (!Dictionary.listWord.isEmpty()) {
            System.out.printf("%-4s%c%-20s%c%-20s\n", "STT", '|', "English", '|', "Vietnamese");
            int i = 1;
            for (Word ele
                    : Dictionary.listWord) {
                System.out.printf("%-5d", i);
                ele.printWord();
                i++;
            }
        }
    }

    public void insertFromCommandline() {
        System.out.println("---------Thêm từ vào từ điển---------");
        System.out.print("Nhập số lượng từ muốn thêm: ");
        int num = Integer.parseInt(sc.nextLine());
//        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.print("Nhập từ muốn thêm: ");
            String spel = sc.nextLine();
            boolean check = false;
            for (Word ele
                    : Dictionary.listWord) {
                if (ele.getWord_taget().equals(spel.trim())) {
                    System.out.println("Từ " + spel + " đã có trong từ điển!! Nhập lại...");
                    check = true;
                    i--;
                    break;
                }
            }

            if (!check) {
                System.out.print("Nhập nghĩa Tiếng Việt: ");
                String expl = sc.nextLine();
                Dictionary.listWord.add(new Word(spel, expl));
            }

        }
        System.out.println("Thêm thành công " + num + " từ vào từ điển!");
    }

    public void insertFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String line = br.readLine();
            while (line != null) {
                if (!line.contains("\t")) {
                    line = br.readLine();
                    continue;
                }
                Word w = new Word(line);
                Dictionary.listWord.add(w);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

    public void dictionaryLookup()  {
        System.out.println("-----------LOOK UP------------");
        System.out.print("Enter word: ");
        String wordLookup = sc.nextLine();
        for (Word ele
                : Dictionary.listWord) {
            if (ele.getWord_taget().equals(wordLookup)) {
                System.out.println("Lookup Success!");
                System.out.print("Your word is: ");
                ele.printWord();
                return;
            }
        }
        System.out.println("Word Not Found!");
    }

    public void dictionarySearcher() {
//        sc = new Scanner(System.in);
        System.out.println("----Tìm kiếm từ tiếng anh----");
        System.out.print("Nhập từ cần tìm: ");
        String wordSearch = sc.nextLine();

        ArrayList<Word> listWordSearch = new ArrayList<>();

        for (Word ele : Dictionary.listWord) {
            if (ele.getWord_taget().indexOf(wordSearch) == 0) {
                listWordSearch.add(ele);
            }
        }

        if (listWordSearch.isEmpty()) {
            System.out.println("Không có trong từ điển !!!");
        } else {
            System.out.println("(Các) từ bắt đầu bằng \"" + wordSearch + "\": ");
            int i = 1;
            for (Word ele
                    : listWordSearch) {
                System.out.printf("%-4d", i);
                ele.printWord();
                i++;
            }
        }
    }

    public void editWordInDic()  {
        System.out.println("--------Sửa từ trong từ điển--------");
        System.out.println("Nhập từ bạn muốn sửa: ");
        String editW = sc.nextLine();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getWord_taget().equals(editW)) {
                System.out.println("Đã thấy từ " + editW + " trong từ điển!");
                System.out.print("Nhập từ thay thế: ");
                String spel = sc.nextLine();
                System.out.print("Nhập nghĩa tiếng việt:");
                String expl = sc.nextLine();
                Dictionary.listWord.set(i, new Word(spel, expl));
                System.out.println("Thêm thành công!!");
                return;
            }
        }
        System.out.println("Không tìm thấy từ: " + editW);
    }

    public void deleteWordInDic()  {
        System.out.println("--------Xóa từ trong từ điển--------");
        System.out.println("Nhập từ bạn muốn xóa: ");
        String delW = sc.nextLine();
       
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getWord_taget().equals(delW)) {
                System.out.println("Đã thấy từ " + delW + " trong từ điển!");
                System.out.println("Bạn có muốn xóa từ " + delW + " không? (Y/N)?");
                char option = sc.nextLine().toCharArray()[0];
                switch (option) {
                    case 'Y':
                    case 'y':
                        Dictionary.listWord.remove(i);
                        System.out.println("Xóa thành công!!");
                        break;
                    case 'N':
                    case 'n':
                        System.out.println("Xóa không thành công!!");
                        break;
                    default:
                        System.out.println("Lỗi");
                        break;
                }
                return;
            }
        }
        System.out.println("Không tìm thấy từ: " + delW);
    }

    public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Word ele : Dictionary.listWord) {
                bw.write(ele.getWord_taget() + "\t" + ele.getWord_explain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

}
