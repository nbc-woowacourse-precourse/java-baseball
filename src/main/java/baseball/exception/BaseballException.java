package baseball.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BaseballException {

    private final int NUMBERLENGTH = 3;

    public void checkNumberSize(
            final String number
    ) {
        if (number.length() < NUMBERLENGTH || number.length() > NUMBERLENGTH) {
            throw new IllegalArgumentException("숫자의 길이가 잘못되었습니다");
        }
    }

    public void checkOverlap(
            final String number
    ) {
        String[] numbers = number.split("");
        Set<String> setList = new HashSet<>(Arrays.asList(numbers));
        if (setList.size() < NUMBERLENGTH) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다");
        }
    }

    public void checkNothing(
            final String number
    ) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("입력을 하고 enter를 쳐주세요");
        }
    }

    public void checkEtc(
            final String number
    ) {
        String regex = "[0-9]+";
        if (!number.matches(regex)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public void checkRestartKey(
            final String number
    ) {
        String regex = "[12]";
        if (!number.matches(regex)) {
            throw new IllegalArgumentException("1과 2만 입력이 가능합니다");
        }
    }
}
