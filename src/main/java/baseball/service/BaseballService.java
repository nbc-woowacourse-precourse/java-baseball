package baseball.service;

import static baseball.constant.Number.DIGITS;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    // Todo: 검증 메소드 구현
    public boolean validateInput(String input) {
        return input.matches("[1-9]{3}")
            && input.chars().distinct().count() == DIGITS.getNumber();
    }
    // Todo : String 을 Integer 로 바꿔야 하는지 다시 생각해볼 것
    public List<Integer> convertInputToNumber(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < DIGITS.getNumber(); i++) {
            char c = input.charAt(i);

            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }
}
