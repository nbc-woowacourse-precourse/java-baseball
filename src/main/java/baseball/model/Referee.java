package baseball.model;

import static baseball.constant.Hint.BALL;
import static baseball.constant.Hint.NOTHING;
import static baseball.constant.Hint.STRIKE;
import static baseball.constant.Number.DIGITS;
import static baseball.constant.Number.THREE_STRIKE;

import baseball.io.OutPut;
import java.util.List;

public class Referee {

    private Computer computer;
    private OutPut outPut;

    public int getBallAndStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = getStrikeCount(computerNumbers, playerNumbers);
        int ball = getBallCount(computerNumbers, playerNumbers);

        System.out.println(makeHint(strike, ball));
        return strike;
    }

    public boolean validateThreeStrike(int strike, List<Integer> computerNumbers) {
        if (strike == THREE_STRIKE.getNumber()) {
            computerNumbers.clear();
            computer.generateRandomNumber();

            outPut.wonTheGame();
            outPut.restartGame();
            outPut.terminateGame();

            return true;
        }
        return false;
    }

    // Todo : if 문을 좀 더 가독성 좋게 만들어 볼 것
    public String makeHint(Integer strike, Integer ball) {
        StringBuilder sb = new StringBuilder();

        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING.getHint());
        }

        if (strike != 0 && ball != 0) {
            sb.append(ball).append(BALL.getHint())
                .append(strike).append(STRIKE.getHint());
        }

        if (ball != 0) {
            sb.append(ball).append(BALL.getHint());
        }

        return sb.toString();
    }

    // Todo : getStrikeCount 과 getBallCount 는 함수형 인터페이스를 사용해 볼 것
    public int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < DIGITS.getNumber(); i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ballCount = 0;

        for (int i = 0; i < DIGITS.getNumber(); i++) {
            if (!computerNumbers.get(i).equals(playerNumbers.get(i))
                && playerNumbers.contains(computerNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
