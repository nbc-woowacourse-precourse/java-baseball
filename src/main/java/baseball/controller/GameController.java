package baseball.controller;

import static baseball.constant.Constant.BALL_STRING;
import static baseball.constant.Constant.DIGITS;
import static baseball.constant.Constant.END_GAME_INPUT;
import static baseball.constant.Constant.INPUT_MESSAGE;
import static baseball.constant.Constant.NOTHING_STRING;
import static baseball.constant.Constant.RESTART_GAME_INPUT;
import static baseball.constant.Constant.RESTART_MESSAGE;
import static baseball.constant.Constant.START_MESSAGE;
import static baseball.constant.Constant.STRIKE_STRING;
import static baseball.constant.Constant.STRIKE_SUCCESS_NUM;
import static baseball.constant.Constant.SUCCESS_MESSAGE;
import static baseball.constant.Constant.TERMINATE_MESSAGE;
import static baseball.constant.Constant.WRONG_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void startGame() {
        System.out.println(START_MESSAGE);

        List<Integer> computerNumbers = generateRandomNumber();

        while (true) {
            System.out.print(INPUT_MESSAGE);
            String input = Console.readLine();

            if (!isValidInput(input)) {
                System.out.println(WRONG_INPUT_MESSAGE);
                break;
            }

            List<Integer> playerNumbers = convertInputToList(input);

            int strike = getStrikeCount(computerNumbers, playerNumbers);
            int ball = getBallCount(computerNumbers, playerNumbers);

            System.out.println(makeHint(strike, ball));

            if (strike == STRIKE_SUCCESS_NUM) {
                computerNumbers.clear();
                computerNumbers = generateRandomNumber();

                System.out.println(SUCCESS_MESSAGE);
                System.out.println(RESTART_MESSAGE);

                String restart = Console.readLine();

                if (restart.equals(END_GAME_INPUT)) {
                    System.out.println(TERMINATE_MESSAGE);
                    break;
                } else if (!restart.equals(RESTART_GAME_INPUT)) {
                    throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
                }
            }
        }
    }

    private static String makeHint(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike != 0) {
            if (ball != 0) {
                sb.append(ball).append(BALL_STRING).append(strike).append(STRIKE_STRING);
                return sb.toString();
            }
            sb.append(strike).append(STRIKE_STRING);
            return sb.toString();
        }
        if (ball != 0) {
            sb.append(ball).append(BALL_STRING);
            return sb.toString();
        }
        sb.append(NOTHING_STRING);
        return sb.toString();
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < DIGITS; i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                int digit = Character.digit(ch, 10);
                numbers.add(digit);
            }
        }
        return numbers;
    }

    private boolean isValidInput(String input) {
        return input.matches("[1-9]{3}") && input.chars().distinct().count() == DIGITS;
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < DIGITS; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < DIGITS; i++) {
            if (!computerNumbers.get(i).equals(playerNumbers.get(i)) && playerNumbers.contains(
                computerNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
