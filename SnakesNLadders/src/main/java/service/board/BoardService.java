package service.board;

import enums.BoardCharacterTypes;
import models.Board;

import java.util.Map;

public interface BoardService {

    Board initBoard(int boardSize, Map<BoardCharacterTypes, Integer> boardCharacterTypesCountMap, int numberOfDices);
}
