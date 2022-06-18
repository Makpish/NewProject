package strategy.MoveStrategy.impl;

import strategy.MoveStrategy.MovementStrategy;

import java.util.List;

public class SumMoveStrategyImpl implements MovementStrategy {
    @Override
    public int doOperation(List<Integer> rolls) {
        return rolls.stream().mapToInt(Integer::intValue).sum();
    }
}
