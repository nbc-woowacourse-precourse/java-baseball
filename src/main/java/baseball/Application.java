package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        try {
            runGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static void runGame() {
        Computer computer = new Computer();
        Player player = new Player();
        Referee referee = new Referee();

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean continueGame = true;

        while (continueGame) {
            List<Integer> secretNumber = computer.generateSecretNumber();
            boolean gameWon = false;

            while (!gameWon) {
                List<Integer> guess = player.makeGuess();
                int strikes = referee.countStrikes(secretNumber, guess);
                int balls = referee.countBalls(secretNumber, guess);

                if (strikes == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameWon = true;
                } else {
                    String resultMessage = getResultMessage(balls, strikes);
                    System.out.println(resultMessage);
                }
            }

            continueGame = askForNewGame();
        }
    }

    private static String getResultMessage(int balls, int strikes) {
        if (balls == 0 && strikes == 0) {
            return "낫싱";
        } else {
            String result = "";
            if (balls > 0) {
                result += balls + "볼 ";
            }
            if (strikes > 0) {
                result += strikes + "스트라이크";
            }
            return result.trim();
        }
    }

    private static boolean askForNewGame() {
        while (true) {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String response = Console.readLine();
            if ("1".equals(response)) {
                return true;
            } else if ("2".equals(response)) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
