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
}
