package uk.co.rowney.gamenight.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerDao {


    private Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

    public PlayerDao() throws SQLException {
    }

    public void addNewPlayer(String playerName) throws SQLException {
        String sql = "INSERT INTO player (name, score) VALUES ('" + playerName + "', 0)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
}
