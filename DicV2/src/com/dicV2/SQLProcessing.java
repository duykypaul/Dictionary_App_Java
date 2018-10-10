package com.dicV2;

import java.sql.*;
import java.util.Collections;

public class SQLProcessing {

    private final String className = "com.mysql.jdbc.Driver";
    private Connection connection;
    private final String user = "ductt";
    private final String pass = "03121997";
    private final String url = "jdbc:mysql://localhost:3306/dictionary?user=" + user
            + "&password=" + pass + "&useUnicode=true&characterEncoding=utf8";
    private final String tableName = "new_dic";

    // Kết nối CSDL
    private boolean connectSQL() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    // Ngắt kết nối CSDL
    private void disconnectSQL() {
        try {
            connection.close();
        } catch (SQLException ex) {

        }
    }

    public boolean dictionaryImportfromSQL() {
        if (connectSQL()) {
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
            } catch (SQLException ex) {
            }
            Collections.sort(Dictionary.listWord, new WordComparator());
            return true;
        }
        return false;
    }

    // Thêm 1 từ vào CSDL
    public void insertToSQL(Word w) {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO new_dic VALUES ('" + w.getWord_taget()
                    + "','" + w.getWord_explain() + "')");
            disconnectSQL();
        } catch (SQLException ex) {
        }
    }

    // Xóa 1 từ trong CSDL
    public void deleteInSQL(Word w) {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM new_dic WHERE word_taget = '" + w.getWord_taget() + "'");
            disconnectSQL();
        } catch (SQLException ex) {
        }
    }

    // Sửa 1 từ trong CSDL
    public void editWordInSQL(Word oldWord, Word newWord) {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE new_dic SET word_taget = '" + newWord.getWord_taget()
              + "',word_explain = '" + newWord.getWord_explain() + "' WHERE word_taget = '" + oldWord.getWord_taget() + "'");
            disconnectSQL();
        } catch (SQLException ex) {
        }
    }
}
