package dic.commandline;

import java.io.*;
import java.util.*;

public class DictionaryManagement {

    private Scanner sc = new Scanner(System.in);
    private final String fileName = "data\\dictionaries.txt";

    // Tìm kiếm nhị phân Word
    public int binarySreachWord(String str) {
        int lo = 0, hi = Dictionary.listWord.size() - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int cp = Dictionary.listWord.get(mid).compareTo(str);

            if (cp < 0) {
                lo = mid + 1;
            } else if (cp > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Tìm kiếm vị trí insert
    public int posInsert(Word w) {
        int lo = 0, hi = Dictionary.listWord.size() - 1, mid;
        // Trường hợp list rỗng
        if(Dictionary.listWord.isEmpty()) {
            return 0;
        }
        
        // Còn lại
        while (true) {
            mid = lo + (hi - lo) / 2;
            int cp = Dictionary.listWord.get(mid).compareTo(w.getWord_taget());

            if (cp < 0) {
                lo = mid + 1;
                if (lo > hi) {
                    return lo;
                }
            } else if (cp > 0) {
                hi = mid - 1;
                if (hi < lo) {
                    return hi + 1;
                }
            } else {
                return -1;
            }
        }
    }

    // In toàn bộ từ
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

    // Thêm vào list từ bàn phím
    public void insertFromCommandline() {
        System.out.println("---------Thêm từ vào từ điển---------");
        System.out.print("Nhập số lượng từ muốn thêm: ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.print("Nhập từ muốn thêm: ");
            String spel = sc.nextLine();
            System.out.print("Nhập nghĩa Tiếng Việt: ");
            String expl = sc.nextLine();
            int pos = posInsert(new Word(spel, expl));
            if(pos == Dictionary.listWord.size()) {
                Dictionary.listWord.add(new Word(spel, expl));
            } else if(pos == -1) {
                System.out.println("Từ \"" + spel + "\" đã có trong từ điển. Nhập lại...");
                i--;
            } else {
                Dictionary.listWord.add(pos,new Word(spel, expl));
                System.out.println("Thành công");
            }
        }
        System.out.println("Thêm thành công " + num + " từ vào từ điển!");
    }

    // Thêm vào list từ file
    public void insertFromFile() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String line = br.readLine();;

            while (line != null) {

                if (line.contains("\t")) {
                } else {
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

    // Tìm kiếm từ chính xác 
    public void dictionaryLookup() {
        System.out.println("-----------Tìm kiếm chính xác------------");
        System.out.print("Nhập từ : ");
        String wordLookup = sc.nextLine();
        int posLookUpW = binarySreachWord(wordLookup);
        if (posLookUpW == -1) {
            System.out.println("Không tìm thấy từ: " + wordLookup);
        } else {
            System.out.println("Đã tìm thấy từ !");
            System.out.print("Từ của bạn là: ");
            Dictionary.listWord.get(posLookUpW).printWord();
        }
    }

    // Tìm kiếm từ thông minh
    public void dictionarySearcher() {
        sc = new Scanner(System.in);
        System.out.println("----Tìm kiếm từ tiếng anh----");
        System.out.print("Nhập từ cần tìm: ");
        String wordSearch = sc.nextLine();

        ArrayList<Word> listWordSearch = new ArrayList<>();

        int posStart = -1;
        int lo = 0, hi = Dictionary.listWord.size() - 1, mid;
        OUTER:
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            int cp = Dictionary.listWord.get(mid).compareTo(wordSearch);
            int posInW = Dictionary.listWord.get(mid).getWord_taget().indexOf(wordSearch);

            if (posInW == 0) {
                posStart = mid;
                break;
            } else {
                if (cp < 0) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        if (posStart == -1) {
            System.out.println("Không có trong từ điển !!!");
        } else {
            int i = posStart;
            while (i < Dictionary.listWord.size()
                    && Dictionary.listWord.get(i).getWord_taget().indexOf(wordSearch) == 0) {
                listWordSearch.add(Dictionary.listWord.get(i));
                i++;
            }
            int j = posStart;
            while (j >= 0 && Dictionary.listWord.get(j).getWord_taget().indexOf(wordSearch) == 0) {
                listWordSearch.add(Dictionary.listWord.get(j));
                j--;
            }

            Collections.sort(listWordSearch, new WordComparator());

            System.out.println("(Các) từ bắt đầu bằng \"" + wordSearch + "\": ");
            int start = 1;
            for (Word ele
                    : listWordSearch) {
                System.out.printf("%-6d", start);
                ele.printWord();
                start++;
            }
        }
    }

    // Chỉnh sửa từ
    public void editWordInDic() {
        System.out.println("--------Sửa từ trong từ điển--------");
        System.out.print("Nhập từ bạn muốn sửa: ");
        String editW = sc.nextLine();
        int posEditW = binarySreachWord(editW);
        if (posEditW == -1) {
            System.out.println("Không tìm thấy từ: " + editW);
        } else {
            System.out.println("Đã thấy từ " + editW + " trong từ điển!");
            System.out.print("Nhập từ thay thế: ");
            String spel = sc.nextLine();
            System.out.print("Nhập nghĩa tiếng việt:");
            String expl = sc.nextLine();
            Dictionary.listWord.set(posEditW, new Word(spel, expl));
            System.out.println("Thêm thành công!!");
        }
    }

    // Xóa từ
    public void deleteWordInDic() {
        System.out.println("--------Xóa từ trong từ điển--------");
        System.out.print("Nhập từ bạn muốn xóa: ");
        String delW = sc.nextLine();
        int posDelW = binarySreachWord(delW);
        if (posDelW == -1) {
            System.out.println("Không tìm thấy từ: " + delW);
        } else {
            System.out.println("Đã thấy từ " + delW + " trong từ điển!");
            System.out.print("Bạn có muốn xóa từ " + delW + " không? (Y/N)? ");
            char option = sc.nextLine().charAt(0);
            switch (option) {
                case 'Y':
                case 'y':
                    Dictionary.listWord.remove(posDelW);
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
        }
    }

    // Xuất từ điển ra file
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
