package Lesson_2;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try {
            connect();
            createTable();
            insertIntoTable();
            selectFromTable();
            deleteFromTable();
            dropTable();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    // 1. Устанавливаем соединение с базой данных.
    public static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        statement = connection.createStatement();
    }

    // 2. Создаем таблицу.
    private static void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " name TEXT,\n " +
                " email TEXT\n" +
                " );");
    }

    // 3. Добавляем запись в таблицу.
    private static void insertIntoTable() throws SQLException {
        statement.executeUpdate("INSERT INTO students (name, email) VALUES ('Anastasia', 'Anastasia281295@gmail.com')," +
                " ('Jane', 'Jane19937788@gmail.com'), ('Andrey', 'Andrey12457@gmail.com');");
    }

    // 4. Получаем запись.
    private static void selectFromTable() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        String sql = String.format("SELECT * FROM students where id = '%s';", res);
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("email"));
        }
    }

    // 5. Удаляем запись.
    private static void deleteFromTable() throws SQLException {
        statement.executeUpdate("DELETE FROM students WHERE id = 3;");
    }

    // 6. Удаляем таблицу.
    private static void dropTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS students;");
    }

    // 7. Закрываем соединение.
    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
