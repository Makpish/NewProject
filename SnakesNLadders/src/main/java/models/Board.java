package models;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private int size;
    private Map<Integer, BoardCharacter> boardCharacterMap;

    public Board(int size) {
        this.size = size;
        boardCharacterMap = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<Integer, BoardCharacter> getBoardCharacterMap() {
        return boardCharacterMap;
    }

    public void setBoardCharacterMap(Map<Integer, BoardCharacter> boardCharacterMap) {
        this.boardCharacterMap = boardCharacterMap;
    }
}
