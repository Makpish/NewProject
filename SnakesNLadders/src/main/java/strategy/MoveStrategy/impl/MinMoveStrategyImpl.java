package strategy.MoveStrategy.impl;

import strategy.MoveStrategy.MovementStrategy;

import java.util.List;
import java.util.NoSuchElementException;

public class MinMoveStrategyImpl implements MovementStrategy {
    @Override
    public int doOperation(List<Integer> rolls) {
        return rolls
                .stream()
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);
    }
}
