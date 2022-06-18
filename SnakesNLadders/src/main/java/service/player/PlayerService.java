package service.player;

import models.Player;

import java.util.List;

public interface PlayerService {
    List<Player> createPlayers(int numberOfPlayers);

    void movePlayer(Player player, int distance);

    void jumpPlayer(Player player, int position);
}
