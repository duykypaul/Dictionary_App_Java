package com.dicV2;

import java.io.*;
import java.util.ArrayList;

public class FileProcessing {

    private final String fileNameDic = "data\\dictionaries.txt";
    private final String fileNameSaved = "data\\saved.dat";
    private final String fileNameHistory = "data\\history.dat";

    public void updateListDic() {
        try {
            FileInputStream fileIn = new FileInputStream(new File(fileNameDic)); 
            ObjectInputStream ojIn = new ObjectInputStream(fileIn);
            Object read = null;
            read = (ArrayList<Word>) ojIn.readObject();
            Dictionary.listWord = (ArrayList<Word>)read;
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

    public void updateListSaved() {
        try {
            FileInputStream fileIn = new FileInputStream(new File(fileNameSaved)); 
            ObjectInputStream ojIn = new ObjectInputStream(fileIn);
            Object read = null;
            read = (ArrayList<Word>) ojIn.readObject();
            ListWordSaved.listWordSaved = (ArrayList<Word>)read;
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

    public void updateListHistory() {
        try {
            FileInputStream fileIn = new FileInputStream(new File(fileNameHistory)); 
            ObjectInputStream ojIn = new ObjectInputStream(fileIn);
            Object read = null;
            read = (ArrayList<Word>) ojIn.readObject();
            ListWordHistory.listWordHistory = (ArrayList<Word>)read;
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

    public boolean updateFileDic() {
        try {
            try (FileOutputStream fileOut = new FileOutputStream(new File(fileNameDic)); ObjectOutputStream ojOut = new ObjectOutputStream(fileOut)) {
                ojOut.writeObject(Dictionary.listWord);
            }
            return true;

        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean updateFileSaved() {
        try {
            try (FileOutputStream fileOut = new FileOutputStream(new File(fileNameSaved)); ObjectOutputStream ojOut = new ObjectOutputStream(fileOut)) {
                ojOut.writeObject(ListWordSaved.listWordSaved);
            }
            return true;

        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean updateFileHistory() {
        try {
            try (FileOutputStream fileOut = new FileOutputStream(new File(fileNameHistory)); ObjectOutputStream ojOut = new ObjectOutputStream(fileOut)) {
                ojOut.writeObject(ListWordHistory.listWordHistory);
            }
            return true;

        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

}
