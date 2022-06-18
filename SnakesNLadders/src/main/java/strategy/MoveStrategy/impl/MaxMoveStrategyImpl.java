package strategy.MoveStrategy.impl;

import strategy.MoveStrategy.MovementStrategy;

import java.util.List;
import java.util.NoSuchElementException;

public class MaxMoveStrategyImpl implements MovementStrategy {
    @Override
    public int doOperation(List<Integer> rolls) {
        return rolls
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
    }
}
