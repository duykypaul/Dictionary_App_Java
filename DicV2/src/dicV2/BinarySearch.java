package dicV2;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {

    public static int binarySearchWord(ArrayList<Word> list, String str) {
        int lo = 0, hi = list.size() - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int cp = list.get(mid).compareTo(str);

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

    public static int posInsertWord(ArrayList<Word> list, String str) {
        int lo = 0, hi = list.size() - 1, mid;
        // Trường hợp list rỗng
        if (list.isEmpty()) {
            return 0;
        }
        // Còn lại
        while (true) {
            mid = lo + (hi - lo) / 2;
            int cp = list.get(mid).compareTo(str);

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

    public static ArrayList<Word> searchSmart(ArrayList<Word> list, String str) {
        ArrayList<Word> listWordSearch = new ArrayList<>();

        int posStart = -1;
        int lo = 0, hi = list.size() - 1, mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            int cp = list.get(mid).compareTo(str);
            int posInW = list.get(mid).getWord_taget().indexOf(str);

            if (posInW == 0) {
                posStart = mid;
                break;
            } else {
                if (cp < 0) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        if (posStart != -1) {
            int i = posStart;
            while (i < list.size() && list.get(i).getWord_taget().indexOf(str) == 0) {
                listWordSearch.add(list.get(i));
                i++;
            }
            int j = posStart - 1;
            while (j >= 0 && list.get(j).getWord_taget().indexOf(str) == 0) {
                listWordSearch.add(list.get(j));
                j--;
            }
            Collections.sort(listWordSearch, new WordComparator());
        }
        return listWordSearch;
    }
}
