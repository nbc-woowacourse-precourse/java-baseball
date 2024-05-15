package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumbers = generateRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (!isValidInput(input)) {
                System.out.println("잘못 입력했습니다. 게임을 종료합니다.");
                break;
            }

            List<Integer> playerNumbers = convertInputToList(input);

            int strike = getStrikeCount(computerNumbers, playerNumbers);
            int ball = getBallCount(computerNumbers, playerNumbers);

            System.out.println(makeHint(strike, ball));

            if (strike == 3) {
                computerNumbers.clear();
                computerNumbers = generateRandomNumber();

                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String restart = Console.readLine();

                if (restart.equals("2")) {
                    System.out.println("게임을 종료합니다.");
                    break;
                } else if (!restart.equals("1")) {
                    throw new IllegalArgumentException("잘못 입력했습니다. 게임을 종료합니다.");
                }
            }
        }
    }

    private static String makeHint(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike != 0) {
            if (ball != 0) {
                sb.append(ball).append("볼").append(strike).append("스트라이크");
                return sb.toString();
            }
            sb.append(strike).append("스트라이크");
            return sb.toString();
        }
        if (ball != 0) {
            sb.append(ball).append("볼");
            return sb.toString();
        }
        sb.append("낫싱");
        return sb.toString();
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                int digit = Character.digit(ch, 10);
                numbers.add(digit);
            }
        }
        return numbers;
    }

    private boolean isValidInput(String input) {
        return input.matches("[1-9]{3}") && input.chars().distinct().count() == 3;
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (!computerNumbers.get(i).equals(playerNumbers.get(i)) && playerNumbers.contains(
                computerNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
