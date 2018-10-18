package uk.co.rowney.gamenight.dao;

import org.springframework.stereotype.Repository;
import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Repository
public class PlayerDao {

    private Statement statement;

    public void addNewPlayer(String[] playerNames) throws SQLException {
        statement = createConnection();

        for (String playerName: playerNames) {
            String sql = "INSERT INTO player (name, score) VALUES ('" + playerName + "', 1000)";
            statement.executeUpdate(sql);
        }
    }

    public Player getPlayerFromId(int id) throws SQLException {
        statement = createConnection();
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
        statement = createConnection();
        String sql = format("SELECT * FROM player ORDER BY score DESC");
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

//    public void updatePlayersScores(String[] playerIds) throws SQLException {
//        Statement statement = createConnection();
//
//        for (String playerId: playerIds) {
//            String sql = format("UPDATE player SET score = score + 3 WHERE id = %s", playerId);
//            statement.executeUpdate(sql);
//        }
//    }

    public List<Player> getMultiplePlayersFromId(String[] idList) throws SQLException {
        statement = createConnection();
        List<Player> playerList = new ArrayList<>();

        for (String id : idList) {
            String sql = format("SELECT * FROM player WHERE id = %s", id);
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Player player = new Player();
                player.setId(resultSet.getInt("id"));
                player.setName(resultSet.getString("name"));
                player.setScore(resultSet.getInt("score"));
                playerList.add(player);
            }
        }

        return playerList;
    }

    public void updatePlayers(List<Player> updatedList) throws SQLException {
        statement = createConnection();

        for (Player player : updatedList) {
            String sql = format("UPDATE player SET score = %s WHERE id = %s", player.getScore(), player.getId());
            statement.executeUpdate(sql);
        }
    }

    private Statement createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        return connection.createStatement();
    }
}
