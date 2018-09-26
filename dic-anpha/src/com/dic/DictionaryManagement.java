package com.dic;

import java.sql.*;
import java.util.ArrayList;
import java.io.*;

public class DictionaryManagement {

    Dictionary dic = new Dictionary();
    private final String className = "com.mysql.jdbc.Driver";
    private Connection connection;
    private final String user = "ductt";
    private final String pass = "03121997";
    private final String url = "jdbc:mysql://localhost:3306/dictionary?user=" + user
            + "&password=" + pass + "&useUnicode=true&characterEncoding=utf8";
    private final String tableName = "my_dic";

    // Kết nối CSDL
    private void connectSQL() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url);

            System.out.println("Kết nối thành công");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found!");
        } catch (SQLException ex) {
            System.out.println("Không kết nối được");
        }
    }

    // Ngắt kết nối CSDL
    private void disconnectSQL() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Chưa ngắt kết nối");
        }
    }

    public void updateDataFromListToFile(ArrayList<Word> list, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File(fileName));
            ObjectOutputStream ojOut = new ObjectOutputStream(fileOut);
            for (Word ele
                    : list) {
                ojOut.writeObject(ele);
            }
            ojOut.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Không có dữ liệu");
        }
    }

    public ArrayList<Word> updateDataFromFileToList(String fileName, ArrayList<Word> list) {
        try {
            FileInputStream fileIn = new FileInputStream(new File(fileName));
            ObjectInputStream ojIn = new ObjectInputStream(fileIn);
            Object oj = ojIn.readObject();
            while (oj != null) {
                Word w = (Word) oj;
                list.add(w);
                oj = ojIn.readObject();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Không có dữ liệu");
        }
        return list;
    }

    // Lấy dữ liệu từ CSDL đưa vào listWord
    public void dictionaryImportfromSQL() {
        connectSQL();
        ResultSet rs;
        String sql = "SELECT * FROM " + tableName;
        Statement st;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Dictionary.listWord.add(new Word(rs.getString(1), rs.getString(2)));
            }
            disconnectSQL();
            System.out.println("Lấy dữ liệu thành công !!!");
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
    }

    // Thêm 1 từ vào listWord
    public void insertToList(Word w) {
        Dictionary.listWord.add(new Word(w));
    }

    // Xóa 1 từ từ listWord
    public void deleteInList(String word_taget) {
        Dictionary.listWord.remove(dic.isInList(word_taget));
    }

    // Sửa một từ từ listWord
    public void editWordInList(String word_taget, String newWordTaget, String newWordExplain) {
        Dictionary.listWord.set(dic.isInList(word_taget), new Word(newWordTaget, newWordExplain));
    }

    // Thêm 1 từ vào CSDL
    public void insertToSQL(Word w) {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO my_dic VALUES ('" + w.getWord_taget()
                    + "','" + w.getWord_explain() + "')");
            disconnectSQL();
            System.out.println("Success");
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
    }

    // Xóa 1 từ trong CSDL
    public void deleteInSQL(String word_taget) {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM my_dic WHERE word_taget = '" + word_taget + "'");
            disconnectSQL();
            System.out.println("Success");
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
    }

    // Sửa 1 từ trong CSDL
    public void editWordInSQL(String word_taget, String newWordTaget, String newWordExplain) {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE my_dic SET word_taget = '" + newWordTaget
                    + "',word_explain = '" + newWordExplain + "' WHERE word_taget = '" + word_taget + "'");
            disconnectSQL();
            System.out.println("Success");
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
    }

    public void addToRecentWords(Word w) {
        if (dic.isInRecentWords(w.getWord_taget()) != -1) {
            return;
        } else {
            if (Dictionary.recentWords.size() >= 100) {
                Dictionary.recentWords.remove(99);
            }
            Dictionary.recentWords.add(0, w);
            updateDataFromListToFile(Dictionary.recentWords, "dataSaved\\recent.txt");
            Dictionary.recentWords.clear();
            Dictionary.recentWords = updateDataFromFileToList("dataSaved\\recent.txt", Dictionary.recentWords);
        }
    }

    public void addToMyWords(Word w) {
        if (dic.isInMyWords(w.getWord_taget()) != -1) {
            return;
        }
        Dictionary.myWords.add(0, w);
        updateDataFromListToFile(Dictionary.recentWords, "dataSaved\\saved.txt");
        Dictionary.myWords.clear();
        Dictionary.myWords = updateDataFromFileToList("dataSaved\\saved.txt", Dictionary.myWords);
    }

}
