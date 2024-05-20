package baseball.model;

import baseball.constant.Number;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < Number.DIGITS.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
