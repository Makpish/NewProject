package models;

import enums.BoardCharacterTypes;

public class BoardCharacter {

    private int startPoint;
    private int endPoinit;
    private BoardCharacterTypes boardCharacterType;

    public BoardCharacter(int startPoint, int endPoinit, BoardCharacterTypes boardCharacterType) {
        this.startPoint = startPoint;
        this.endPoinit = endPoinit;
        this.boardCharacterType = boardCharacterType;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getEndPoinit() {
        return endPoinit;
    }

    public void setEndPoinit(int endPoinit) {
        this.endPoinit = endPoinit;
    }

    public BoardCharacterTypes getBoardCharacterType() {
        return boardCharacterType;
    }

    public void setBoardCharacterType(BoardCharacterTypes boardCharacterType) {
        this.boardCharacterType = boardCharacterType;
    }
}
