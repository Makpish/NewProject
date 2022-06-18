import enums.BoardCharacterTypes;
import models.Game;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.game.GameService;
import service.game.impl.GameServiceImpl;
import strategy.MoveStrategy.MovementStrategy;
import strategy.MoveStrategy.impl.SumMoveStrategyImpl;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("/Users/yash.mittal/Desktop/NewProject/SnakesNLadders/src/main/resources/config.json"));
        JSONObject jsonObject = (JSONObject) obj;

        int numOfPlayers = ((Long) jsonObject.get("PlayerCount")).intValue();
        int boardSize = ((Long) jsonObject.get("BoardSize")).intValue();
        int noOfSnakes = ((Long) jsonObject.getOrDefault("snakes", 0)).intValue();
        int noOfLadders = ((Long) jsonObject.getOrDefault("ladders", 0)).intValue();
        int numOfDice = ((Long) jsonObject.getOrDefault("dices", 1)).intValue();

        MovementStrategy movementStrategy = new SumMoveStrategyImpl();

        Map<BoardCharacterTypes, Integer> boardCharacterTypesIntegerMap = new HashMap<BoardCharacterTypes, Integer>() {{
            put(BoardCharacterTypes.SNAKE, noOfSnakes);
            put(BoardCharacterTypes.LADDER, noOfLadders);
        }};

        GameService gameService = new GameServiceImpl();
        Game game = gameService.initGame(numOfPlayers, boardSize, boardCharacterTypesIntegerMap, numOfDice, movementStrategy);

        gameService.simulateGame(game);
    }
}
