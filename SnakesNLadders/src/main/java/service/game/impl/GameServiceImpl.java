package service.game.impl;

import enums.BoardCharacterTypes;
import models.Game;
import models.Player;
import service.board.BoardService;
import service.board.impl.BoardServiceImpl;
import service.game.GameService;
import service.gameMoves.GameMovesService;
import service.gameMoves.impl.GameMovesServiceImpl;
import service.player.PlayerService;
import service.player.PlayerServiceImpl;
import strategy.MoveStrategy.MovementStrategy;

import java.util.Map;

public class GameServiceImpl implements GameService {

    private final BoardService boardService;
    private final PlayerService playerService;
    private final GameMovesService gameMovesService;

    public GameServiceImpl() {
        this.gameMovesService = new GameMovesServiceImpl();
        this.boardService = new BoardServiceImpl();
        this.playerService = new PlayerServiceImpl();
    }


    @Override
    public Game initGame(int playerCount, int boardSize, Map<BoardCharacterTypes, Integer> boardCharacterTypesCountMap,
                         int diceCount, MovementStrategy movementStrategy) {
        return new Game(boardService.initBoard(boardSize, boardCharacterTypesCountMap, diceCount),
                playerService.createPlayers(playerCount),
                diceCount,
                movementStrategy);
    }

    @Override
    public void simulateGame(Game game) {
        int playerTurn = 0;
        int totalPlayer = game.getPlayers().size();
        while (true) {
            Player nextPlayer = game.getPlayers().get(playerTurn % totalPlayer);
            int diceRoll = game.getMovementStrategy().doOperation(gameMovesService.playChance(game.getDice()));
            if (gameMovesService.validMove(game.getBoard(), nextPlayer, diceRoll)) {
                int initialPosition = nextPlayer.getPlayerPosition();
                playerService.movePlayer(nextPlayer, diceRoll);
                if (gameMovesService.hasWon(game.getBoard(), nextPlayer)) {
                    System.out.println("Player " + nextPlayer.getPlayerId() + " wins the game");
                    return;
                }
                while (true) {
                    if (game.getBoard().getBoardCharacterMap().containsKey(nextPlayer.getPlayerPosition())) {
//                        Boa
                        System.out.println("Player: " + nextPlayer.getPlayerId() + " got " + game.getBoard().getBoardCharacterMap().get(nextPlayer.getPlayerPosition()).getBoardCharacterType().name());
                        nextPlayer.setPlayerPosition(game.getBoard().getBoardCharacterMap().get(nextPlayer.getPlayerPosition()).getEndPoinit());
                    } else {
                        break;
                    }
                }
                System.out.println("Player " + nextPlayer.getPlayerId() + " rolled a " + diceRoll
                        + " and moved from " + initialPosition + " to " + nextPlayer.getPlayerPosition());
                for (int i = 0; i < totalPlayer; i++) {
                    if (i != playerTurn % totalPlayer && game.getPlayers().get(i).getPlayerPosition() == nextPlayer.getPlayerPosition()) {
                        game.getPlayers().get(i).setPlayerPosition(1);
                        System.out.println("Player " + game.getPlayers().get(i).getPlayerId() + " got crushed by Player "
                                + nextPlayer.getPlayerId() + " and moved to position 1.");
                    }
                }
            } else {
                System.out.println("Player " + nextPlayer.getPlayerId() + " rolled a " + diceRoll
                        + " and stays");
            }
            ++playerTurn;
        }
    }
}
