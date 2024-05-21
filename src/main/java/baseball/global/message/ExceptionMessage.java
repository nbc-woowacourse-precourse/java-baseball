package baseball.global.message;

public enum ExceptionMessage {
    NUMBERSIZE("숫자의 길이가 잘못되었습니다"),
    OVERLAP("중복된 숫자가 존재합니다"),
    NOTHING("입력을 하고 enter를 쳐주세요"),
    ETC("1과 9사이의 숫자를 입력해주세요"),
    RESTARTKEY("1과 2만 입력이 가능합니다");

    private String message;

    ExceptionMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }

}
