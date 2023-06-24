package com.playlists;

import java.sql.*;

public class DBConnection {

    public static void main(String ...args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/board_svc","root", "sush9301664636#");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from message_boards");
        while(resultSet.next())
        {

            System.out.println(resultSet.getString(1)+"    "+resultSet.getString(2));
            //System.out.println(resultSet.getString(2));
        }
    }
}
