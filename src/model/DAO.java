import java.sql.*;

public abstract class DAO {

    private static void connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db")) {

            System.out.println("Conexão realizada !!!!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}