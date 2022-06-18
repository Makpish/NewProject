package service.gameMoves.impl;

import models.Board;
import models.Dice;
import models.Player;
import service.gameMoves.GameMovesService;

import java.util.List;
import java.util.stream.Collectors;

public class GameMovesServiceImpl implements GameMovesService {

    @Override
    public List<Integer> playChance(List<Dice> dices) {
        return dices.stream().map(Dice::roll).collect(Collectors.toList());
    }

    @Override
    public boolean validMove(Board board, Player player, int jump) {
        return player.getPlayerPosition() + jump <= board.getSize();
    }

    @Override
    public boolean hasWon(Board board, Player player) {
        return player.getPlayerPosition() == board.getSize();
    }
}
