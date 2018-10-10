package uk.co.rowney.gamenight.dao;

import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class PlayerDao {

    public void addNewPlayer(String playerName) throws SQLException {
        Statement statement = createConnection();
        String sql = "INSERT INTO player (name, score) VALUES ('" + playerName + "', 0)";
        statement.executeUpdate(sql);
    }

    public Player getPlayerFromId(int id) throws SQLException {
        Statement statement = createConnection();
        String sql = format("SELECT * FROM player WHERE id = %s", id);
        ResultSet resultSet = statement.executeQuery(sql);

        Player player = new Player();
        while(resultSet.next()){
            player.setId(id);
            player.setName(resultSet.getString("name"));
            player.setScore(resultSet.getInt("score"));
        }

        return player;
    }

    public List<Player> getAllPlayers() throws SQLException {
        Statement statement = createConnection();
        String sql = format("SELECT * FROM player");
        ResultSet resultSet = statement.executeQuery(sql);

        List<Player> playerList = new ArrayList<>();
        while(resultSet.next()){
            Player player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("name"));
            player.setScore(resultSet.getInt("score"));
            playerList.add(player);
        }

        return playerList;
    }

    public void updatePlayersScores(String[] playerIds) throws SQLException {
        Statement statement = createConnection();

        for (String playerId: playerIds) {
            String sql = format("UPDATE player SET score = score + 3 WHERE id = %s", playerId);
            statement.executeUpdate(sql);
        }
    }

    private Statement createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        return connection.createStatement();
    }
}
