package baseball;

import java.util.List;

public class Referee {
    public int countStrikes(List<Integer> secretNumber, List<Integer> guess) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (secretNumber.get(i).equals(guess.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    public int countBalls(List<Integer> secretNumber, List<Integer> guess) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (secretNumber.contains(guess.get(i)) && !secretNumber.get(i).equals(guess.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    public static String getResultMessage(int balls, int strikes) {
        if (balls == 0 && strikes == 0) return "낫싱";
        StringBuilder result = new StringBuilder();
        if (balls > 0) result.append(balls).append("볼 ");
        if (strikes > 0) result.append(strikes).append("스트라이크");
        return result.toString().trim();
    }
}
