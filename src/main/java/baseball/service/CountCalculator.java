package baseball.service;

import java.util.List;

@FunctionalInterface
public interface CountCalculator {
    int calculate(List<Integer> computerNumbers, List<Integer> playerNumbers);
}
