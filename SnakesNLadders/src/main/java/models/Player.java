package models;

public class Player {

    private int playerId;
    private int playerPosition;

    public Player(int playerNumber) {
        this.playerId = playerNumber;
        this.playerPosition = 1;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
}
