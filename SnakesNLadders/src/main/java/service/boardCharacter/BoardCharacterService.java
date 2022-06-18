package service.boardCharacter;

import enums.BoardCharacterTypes;
import models.BoardCharacter;

import java.util.Set;

public interface BoardCharacterService {

    BoardCharacter generateCharacter(Set<Integer> startPositions, Set<Integer> endPositions, BoardCharacterTypes boardCharacterType);
}
