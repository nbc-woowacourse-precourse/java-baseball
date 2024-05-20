package baseball.service;

import baseball.exception.BaseballException;
import baseball.io.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballService {

    private final Output output = new Output();
    private final BaseballException baseballException = new BaseballException();

    private final int STARTNUMBER = 1;
    private final int ENDNUMBER = 9;
    private final int NUMBERRANGE = 3;

    private final int STRIKEZERO = 0;

    private final int BALLZERO = 0;

    private int strikeCount = 0;
    private int ballCount = 0;

    public String makeAnswerNumber() {
        List<Integer> answerNumbers = Randoms.pickUniqueNumbersInRange(STARTNUMBER, ENDNUMBER, NUMBERRANGE);
        StringBuilder answerNumber = new StringBuilder();
        for (Integer num : answerNumbers) {
            answerNumber.append(num);
        }
        return String.valueOf(answerNumber);
    }

    public boolean checkNumber(
            final String inputNumber,
            final String answerNumber
    ) {
        checkException(inputNumber);
        if (inputNumber.equals(answerNumber)) {
            output.endGame();
            return false;
        }
        if (checkAnswer(inputNumber, answerNumber)) {
            return true;
        }
        return false;
    }

    private boolean checkAnswer(
            final String inputNumber,
            final String answerNumber
    ) {
        String[] inputNumbers = inputNumber.split("");
        String[] answerNumbers = answerNumber.split("");
        countNumber(inputNumbers, answerNumbers);

        if (strikeCount == 0 & ballCount == 0) {
            output.nothing();
            return true;
        }
        output.output(ballCount, strikeCount);
        strikeCount = 0;
        ballCount = 0;
        return true;
    }

    private void countNumber(
            final String[] inputNumbers,
            final String[] answerNumbers
    ) {
        for (int i = 0; i < NUMBERRANGE; i++) {
            if (inputNumbers[i].equals(answerNumbers[i])) {
                strikeCount++;
            }
            for (int j = 0; j < answerNumbers.length; j++) {
                if (i != j & inputNumbers[i].equals(answerNumbers[j])) {
                    ballCount++;
                }
            }
        }
    }


    private void checkException(
            final String number
    ) {
        baseballException.checkEtc(number);
        baseballException.checkNothing(number);
        baseballException.checkNumberSize(number);
        baseballException.checkOverlap(number);
    }
}
