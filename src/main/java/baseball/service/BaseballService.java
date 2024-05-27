package baseball.service;

import static baseball.constant.Hint.BALL;
import static baseball.constant.Hint.NOTHING;
import static baseball.constant.Hint.STRIKE;
import static baseball.constant.Message.ERROR_MESSAGE;
import static baseball.constant.Number.DIGITS;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class BaseballService {

    public void getInput(String input) {
        if (!validateInput(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage());
        }
    }

    public boolean validateInput(String input) {
        return validateInputDigits(input) && validateInputDuplicated(input);
    }

    public boolean validateInputDigits(String input) {
        return input.matches("\\d{" + DIGITS.getNumber() + "}");
    }

    public boolean validateInputDuplicated(String input) {
        return input.chars().distinct().count() == DIGITS.getNumber();
    }

    public int getStrike(String input, List<Integer> computerNumbers) {
        List<Integer> playerNumbers = convertInputToNumber(input);
        int strike = getStrikeCount(computerNumbers, playerNumbers);
        int ball = getBallCount(computerNumbers, playerNumbers);

        System.out.println(makeHint(strike, ball));
        return strike;
    }

    public List<Integer> convertInputToNumber(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < DIGITS.getNumber(); i++) {
            char c = input.charAt(i);

            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    public String makeHint(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike != 0) {
            if (ball != 0) {
                sb.append(ball).append(BALL.getHint())
                    .append(strike).append(STRIKE.getHint());
                return sb.toString();
            }
            sb.append(strike).append(STRIKE.getHint());
            return sb.toString();
        }
        if (ball != 0) {
            sb.append(ball).append(BALL.getHint());
            return sb.toString();
        }
        sb.append(NOTHING.getHint());
        return sb.toString();
    }

    public int getBallCount(
        List<Integer> computerNumbers,
        List<Integer> playerNumbers) {

        return calculateCount(
            computerNumbers, playerNumbers, (compNum, playerNum) ->
                !compNum.equals(playerNum) && playerNumbers.contains(compNum)
        );
    }

    public int getStrikeCount(
        List<Integer> computerNumbers,
        List<Integer> playerNumbers) {

        return calculateCount(computerNumbers, playerNumbers, Integer::equals);
    }

    private int calculateCount(
        List<Integer> computerNumbers,
        List<Integer> playerNumbers,
        BiPredicate<Integer, Integer> condition) {

        int count = 0;

        for (int i = 0; i < DIGITS.getNumber(); i++) {
            if (condition.test(computerNumbers.get(i), playerNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
