package dic.commandline;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class DictionaryManagement {
    Dictionary dic = new Dictionary();

    private Scanner sc = new Scanner(System.in);
    private final String fileName = "data\\dictionaries.txt";

    // Tìm kiếm nhị phân Word
    public int binarySreachWord(String str) {
        int lo = 0, hi = dic.listWord.size() - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int cp = dic.listWord.get(mid).compareTo(str);

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
    public int posInsert(String s) {
        int lo = 0, hi = dic.listWord.size() - 1, mid;
        // Trường hợp list rỗng
        if (dic.listWord.isEmpty()) {
            return 0;
        }

        // Còn lại
        while (true) {
            mid = lo + (hi - lo) / 2;
            int cp = dic.listWord.get(mid).compareTo(s);

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
        if (!dic.listWord.isEmpty()) {
            System.out.printf("%-5s%c%-19s%c%-20s\n", "Num", '|', "English", '|', "Vietnamese");
            int i = 1;
            for (Word ele
                    : dic.listWord) {
                System.out.printf("%-5d", i);
                ele.printWord();
                i++;
            }
        }
    }

    // Thêm vào list từ bàn phím
    public void insertFromCommandline() {
        System.out.println("---------Add Word---------");
        System.out.print("Enter numbers of word: ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.print("Enter word : ");
            String spel = sc.nextLine();
            System.out.print("Enter spelling: ");
            String expl = sc.nextLine();
            int pos = posInsert(spel);
            if (pos == dic.listWord.size()) {
                dic.listWord.add(new Word(spel, expl));
                System.out.println("Success");
            } else if (pos == -1) {
                System.out.println("Word Exists In dic. Try Again...");
                i--;
            } else {
                dic.listWord.add(pos, new Word(spel, expl));
                System.out.println("Success");
            }
        }
    }

    // Thêm vào list từ file
    public void insertFromFile() {
//        BufferedReader br = null;
//
//        try {
//            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
//            String line = br.readLine();;
//
//            while (line != null) {
//
//                if (line.contains("\t")) {
//                } else {
//                    line = br.readLine();
//                    continue;
//                }
//                Word w = new Word(line);
//                dic.listWord.add(w);
//                line = br.readLine();
//            }
//            Collections.sort(dic.listWord, new WordComparator());
//            br.close();
//        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
//            System.out.println("Error " + ex);
//        } catch (IOException ex) {
//            System.out.println("Error " + ex);
//        }
        try (Stream <String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)){
	            stream.forEach((String line) ->{
	                dic.listWord.add(new Word(line));
	            });
	        } catch (Exception e) {
	            System.out.println("Error " + e);
	        }
    }

    // Tìm kiếm từ chính xác 
    public void dictionaryLookup() {
        System.out.println("-----------Lookup------------");
        System.out.print("Enter Word : ");
        String wordLookup = sc.nextLine();
        int posLookUpW = binarySreachWord(wordLookup);
        if (posLookUpW == -1) {
            System.out.println("Dont't have word: \"" + wordLookup + "\" in dictionary.");
        } else {
            System.out.println("Success !");
            System.out.print("Your word is: ");
            dic.listWord.get(posLookUpW).printWord();
        }
    }

    // Tìm kiếm từ thông minh
    public void dictionarySearcher() {
        sc = new Scanner(System.in);
        System.out.println("----Searcher----");
        System.out.print("Enter word: ");
        String wordSearch = sc.nextLine();

        ArrayList<Word> listWordSearch = new ArrayList<>();

        int posStart = -1;
        int lo = 0, hi = dic.listWord.size() - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int cp = dic.listWord.get(mid).compareTo(wordSearch);
            int posInW = dic.listWord.get(mid).getWord_taget().indexOf(wordSearch);

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
            System.out.println("Don't have in dictionary !!!");
        } else {

            int i = posStart;
            while (i < dic.listWord.size()
                    && dic.listWord.get(i).getWord_taget().indexOf(wordSearch) == 0) {
                listWordSearch.add(dic.listWord.get(i));
                i++;
            }
            int j = posStart - 1;
            while (j >= 0 && dic.listWord.get(j).getWord_taget().indexOf(wordSearch) == 0) {
                listWordSearch.add(dic.listWord.get(j));
                j--;
            }

            Collections.sort(listWordSearch, new WordComparator());

            System.out.println("Word(s) start with \"" + wordSearch + "\": ");
            System.out.printf("%-5s%c%-19s%c%-20s\n", "Num", '|', "English", '|', "Vietnamese");
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
        System.out.println("--------Edit Word--------");
        System.out.print("Enter word: ");
        String editW = sc.nextLine();
        int posEditW = binarySreachWord(editW);
        if (posEditW == -1) {
            System.out.println("Don't find: " + editW);
        } else {
            System.out.print("Enter changing word: ");
            String spel = sc.nextLine();
            System.out.print("Enter spelling:");
            String expl = sc.nextLine();
            // Xóa rồi thêm 
            dic.listWord.remove(posEditW);
            dic.listWord.add(posInsert(spel), new Word(spel, expl));

            System.out.println("Success!!");
        }
    }

    // Xóa từ
    public void deleteWordInDic() {
        System.out.println("--------Delete Word--------");
        System.out.print("Enter word: ");
        String delW = sc.nextLine();
        int posDelW = binarySreachWord(delW);
        if (posDelW == -1) {
            System.out.println("Don't find: " + delW);
        } else {
            System.out.print("Do you want to delete word \"" + delW + "\" (Y/N)? ");
            char option = sc.nextLine().charAt(0);
            switch (option) {
                case 'Y':
                case 'y':
                    dic.listWord.remove(posDelW);
                    System.out.println("Success!!");
                    break;
                case 'N':
                case 'n':
                    System.out.println("No Success!!");
                    break;
                default:
                    System.out.println("Fail");
                    break;
            }
        }
    }

    // Xuất từ điển ra file
    public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Word ele : dic.listWord) {
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
