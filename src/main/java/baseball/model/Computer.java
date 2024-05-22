package baseball.model;

import static baseball.constant.Number.DIGITS;
import static baseball.constant.Number.LAST_NUM;
import static baseball.constant.Number.START_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < DIGITS.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM.getNumber(), LAST_NUM.getNumber());

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
