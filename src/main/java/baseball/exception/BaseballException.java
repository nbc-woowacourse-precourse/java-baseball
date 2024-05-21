package baseball.exception;

import baseball.global.message.ExceptionMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class BaseballException {

    private final int NUMBERLENGTH = 3;

    private final String ETC = "[1-9]+";
    private final String RESTARTKEY = "[12]";

    private void validateInput(
            final String number,
            final Consumer<String> validator
    ) {
        validator.accept(number);
    }

    public void checkNumberSize(
            final String number
    ) {
        validateInput(number, num -> {
            if (num.length() < NUMBERLENGTH || num.length() > NUMBERLENGTH) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBERSIZE.getMessage());
            }
        });
    }

    public void checkOverlap(
            final String number
    ) {
        validateInput(number, num -> {
            String[] numbers = num.split("");
            Set<String> setList = new HashSet<>(Arrays.asList(numbers));
            if (setList.size() < NUMBERLENGTH) {
                throw new IllegalArgumentException(ExceptionMessage.OVERLAP.getMessage());
            }
        });
    }

    public void checkNothing(
            final String number
    ) {
        validateInput(number, num -> {
            if (num.isEmpty()) {
                throw new IllegalArgumentException(ExceptionMessage.NOTHING.getMessage());
            }
        });
    }

    public void checkEtc(
            final String number
    ) {
        validateInput(number, num -> {
            if (!num.matches(ETC)) {
                throw new IllegalArgumentException(ExceptionMessage.ETC.getMessage());
            }
        });
    }

    public void checkRestartKey(
            final String number
    ) {
        validateInput(number, num -> {
            if (!num.matches(RESTARTKEY)) {
                throw new IllegalArgumentException(ExceptionMessage.RESTARTKEY.getMessage());
            }
        });
    }

}
