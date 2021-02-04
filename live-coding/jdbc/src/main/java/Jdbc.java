import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) {
        //Fetch credentials from .env file
        Dotenv dotenv = Dotenv.load();
        final String db_url = dotenv.get("DB_URL"); //jdbc:mysql://localhost:3306/mindera_school
        final String db_user = dotenv.get("DB_USER"); //root
        final String db_password = dotenv.get("DB_PASSWORD"); //root

        //Create DB connection
        try (Connection connection = DriverManager.getConnection(db_url, db_user, db_password)) {
            String query = "SELECT * FROM students";
            String preparedStatementQuery = "UPDATE students SET first_name=? WHERE id=?";

            //Create a prepared statement
            try (PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementQuery)) {
                //Replace parameters in prepared statement
                preparedStatement.setString(1,"Novo Nome");
                preparedStatement.setInt(2,1);
                //Execute query
                preparedStatement.executeUpdate();
                //Replace parameters in prepared statement
                preparedStatement.setString(1, "Outro Novo Nome");
                preparedStatement.setInt(2,4);
                //Execute query
                preparedStatement.executeUpdate();
            }

            //Create a statement
            try (Statement statement = connection.createStatement()) {
                //Execute query and store results in a ResultSet variable
                ResultSet resultSet = statement.executeQuery(query);

                //Iterate through the results
                while (resultSet.next()) {
                    //Fetch and print data from result
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    System.out.println(id + ": " + firstName + " " + lastName);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
