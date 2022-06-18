package service.player;

import models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerServiceImpl implements PlayerService {
    @Override
    public List<Player> createPlayers(int numberOfPlayers) {
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++)
            players.add(new Player(i));
        return players;
    }

    @Override
    public void movePlayer(Player player, int distance) {
        player.setPlayerPosition(player.getPlayerPosition() + distance);
    }

    @Override
    public void jumpPlayer(Player player, int position) {
        player.setPlayerPosition(position);
    }
}
