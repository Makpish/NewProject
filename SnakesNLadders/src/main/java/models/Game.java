package models;

import strategy.MoveStrategy.MovementStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Dice> dice;
    private MovementStrategy movementStrategy;

    public Game(Board board, List<Player> players, int numOfDices, MovementStrategy movementStrategy) {
        this.board = board;
        this.players = players;
        this.dice = new ArrayList<>();
        for (int i = 0; i < numOfDices; i += 1) {
            this.dice.add(new Dice());
        }
        this.movementStrategy = movementStrategy;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Dice> getDice() {
        return dice;
    }

    public void setDice(List<Dice> dice) {
        this.dice = dice;
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }
}
