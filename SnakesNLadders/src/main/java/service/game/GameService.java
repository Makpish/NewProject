package service.game;

import enums.BoardCharacterTypes;
import models.Game;
import strategy.MoveStrategy.MovementStrategy;

import java.util.Map;

public interface GameService {

    Game initGame(int playerCount, int boardSize, Map<BoardCharacterTypes, Integer> boardCharacterTypesCountMap, int diceCount, MovementStrategy movementStrategy);

    void simulateGame(Game game);
}
