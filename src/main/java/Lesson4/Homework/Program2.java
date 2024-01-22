package Lesson4.Homework;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Program2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "password"; // Replace with your actual password

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Creating the SchoolDB database
            createDatabase(connection, "SchoolDB");
            System.out.println("Database created successfully");

            // Using the SchoolDB database
            useDatabase(connection, "SchoolDB");
            System.out.println("Using database successfully");

            // Creating the Courses table
            createCoursesTable(connection);
            System.out.println("Table created successfully");

            // Inserting data into Courses table
            insertCourse(connection, "Mathematics", 100);
            insertCourse(connection, "Physics", 80);
            System.out.println("Data inserted successfully");

            // Reading data from Courses table
            List<Course> courses = readCourses(connection);
            for (Course course : courses) {
                System.out.println(course);
            }
            System.out.println("Data read successfully");

            // Updating data in Courses table
            updateCourse(connection, 1, "Advanced Mathematics", 120);
            System.out.println("Data updated successfully");

            // Deleting data from Courses table
            deleteCourse(connection, 2);
            System.out.println("Data deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDatabase(Connection connection, String dbName) throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName + ";";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection, String dbName) throws SQLException {
        String sql = "USE " + dbName + ";";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }

    private static void createCoursesTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }

    private static void insertCourse(Connection connection, String title, int duration) throws SQLException {
        String sql = "INSERT INTO Courses (title, duration) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setInt(2, duration);
            statement.executeUpdate();
        }
    }

    private static List<Course> readCourses(Connection connection) throws SQLException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Courses;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int duration = resultSet.getInt("duration");
                courses.add(new Course(title, duration));
            }
        }
        return courses;
    }

    private static void updateCourse(Connection connection, int id, String title, int duration) throws SQLException {
        String sql = "UPDATE Courses SET title=?, duration=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setInt(2, duration);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    private static void deleteCourse(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM Courses WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
