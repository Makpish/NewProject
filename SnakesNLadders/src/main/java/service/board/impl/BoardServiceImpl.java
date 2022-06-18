package service.board.impl;

import enums.BoardCharacterTypes;
import models.Board;
import models.BoardCharacter;
import service.board.BoardService;
import service.boardCharacter.BoardCharacterService;
import service.boardCharacter.impl.BoardCharacterServiceImpl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BoardServiceImpl implements BoardService {

    private final BoardCharacterService boardCharacterService;

    public BoardServiceImpl() {
        this.boardCharacterService = new BoardCharacterServiceImpl();
    }

    @Override
    public Board initBoard(int boardSize, Map<BoardCharacterTypes, Integer> boardCharacterTypesCountMap, int numberOfDices) {
        Board board = new Board(boardSize);

        Set<Integer> startPositions = new HashSet<>();
        Set<Integer> endPositions = new HashSet<>();

        for (int i = numberOfDices; i < boardSize - numberOfDices; i++) {
            startPositions.add(i);
            endPositions.add(i);
        }

        for (Map.Entry<BoardCharacterTypes, Integer> character : boardCharacterTypesCountMap.entrySet()) {
            for (int i = 0; i < character.getValue(); i++) {

                BoardCharacter boardCharacter = boardCharacterService.generateCharacter(startPositions, endPositions, character.getKey());

                board.getBoardCharacterMap().put(boardCharacter.getStartPoint(), boardCharacter);
                startPositions.remove(boardCharacter.getStartPoint());
                endPositions.remove(boardCharacter.getEndPoinit());
            }
        }

        return board;
    }

    public boolean checkCycle(BoardCharacter boardCharacter, Board board) {
        Set<Integer> visited = new HashSet<>();
        int startPoint = boardCharacter.getEndPoinit();
        visited.add(boardCharacter.getStartPoint());
        boolean flag = false;
        while (true) {
            if (visited.contains(startPoint)) {
                flag = true;
                break;
            }

            if (board.getBoardCharacterMap().containsKey(startPoint)) {
                visited.add(startPoint);
                startPoint = board.getBoardCharacterMap().get(startPoint).getEndPoinit();
            } else {
                break;
            }
        }

        return flag;
    }
}
