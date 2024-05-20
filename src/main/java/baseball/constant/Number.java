package baseball.constant;

public enum Number {

    DIGITS(3), THREE_STRIKE(3);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
