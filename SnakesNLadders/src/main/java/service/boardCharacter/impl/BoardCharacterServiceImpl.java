package service.boardCharacter.impl;

import enums.BoardCharacterTypes;
import models.BoardCharacter;
import service.boardCharacter.BoardCharacterService;

import java.util.Random;
import java.util.Set;

public class BoardCharacterServiceImpl implements BoardCharacterService {

    Random random = new Random();

    @Override
    public BoardCharacter generateCharacter(Set<Integer> startPositions, Set<Integer> endPositions, BoardCharacterTypes boardCharacterType) {
        while (true) {
            Integer[] arrayNumbers = startPositions.toArray(new Integer[startPositions.size()]);
            int randomStart = arrayNumbers[random.nextInt(startPositions.size())];

            arrayNumbers = endPositions.toArray(new Integer[endPositions.size()]);
            int randomEnd = arrayNumbers[random.nextInt(endPositions.size())];

            if (boardCharacterType.validate(randomStart, randomEnd)) {
                System.out.println("Charr - " + boardCharacterType.name() + " start " + randomStart +  " end " + randomEnd);
                return new BoardCharacter(randomStart, randomEnd, boardCharacterType);
            }
        }
    }
}
