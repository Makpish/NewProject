package service.gameMoves;

import models.Board;
import models.Dice;
import models.Player;

import java.util.List;

public interface GameMovesService {

    List<Integer> playChance(List<Dice> dices);

    boolean validMove(Board board, Player player, int jump);

    boolean hasWon(Board board, Player player);
}
