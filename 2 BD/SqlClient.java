package khlebnikov.viktor.geekbrains.java_two.chat.server.core;

import java.sql.*;

public class SqlClient {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement changeNicknameStatement;


    public static Connection connect() {
        try {
            if (connection==null){
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:chat-server/clients.db");
                statement = connection.createStatement();}
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static String getNickname(String login, String password) {
        PreparedStatement preparedStatementGetNick = connection.prepareStatement("SELECT nick")
        String query = String.format("select nickname from clients where login='%s' and password='%s'",
                login, password);
        try (ResultSet set = statement.executeQuery(query)) {
            if (set.next()) {
                return set.getString("nickname");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public static boolean changeNickname(String newNickname, String login, String password) {

        String query = String.format("UPDATE clients SET nickname = '%s' WHERE login = '%s' AND password = %d",
                newNickname, login, password);
        try (ResultSet set = statement.executeQuery(query)) {
            if (set.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

}
