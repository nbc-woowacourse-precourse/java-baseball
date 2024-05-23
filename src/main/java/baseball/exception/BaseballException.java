package baseball.exception;

import baseball.global.message.ExceptionMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;

public class BaseballException {

    private final int NUMBERLENGTH = 3;

    private final String ETC = "[1-9]+";
    private final String RESTARTKEY = "[12]";

    public void validateInput(
            final String number,
            final Function<String, Boolean> validator,
            final String errorMessage
    ) {
        if (!validator.apply(number)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void checkNumberSize(final String number) {
        validateInput(
                number,
                num -> num.length() == NUMBERLENGTH,
                ExceptionMessage.NUMBERSIZE.getMessage()
        );
    }

    public void checkOverlap(final String number) {
        validateInput(
                number,
                num -> new HashSet<>(Arrays.asList(num.split(""))).size() == NUMBERLENGTH,
                ExceptionMessage.OVERLAP.getMessage()
        );
    }

    public void checkNothing(final String number) {
        validateInput(
                number,
                num -> !num.isEmpty(),
                ExceptionMessage.NOTHING.getMessage()
        );
    }

    public void checkEtc(final String number) {
        validateInput(
                number,
                num -> num.matches(ETC),
                ExceptionMessage.ETC.getMessage()
        );
    }

    public void checkRestartKey(final String number) {
        validateInput(
                number,
                num -> num.matches(RESTARTKEY),
                ExceptionMessage.RESTARTKEY.getMessage()
        );
    }

}
