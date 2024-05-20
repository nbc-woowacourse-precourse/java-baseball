package baseball.global.message;

public enum DefaultMessage {
    START("숫자 야구 게임을 시작합니다."),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    THREESTRIKE("3스트라이크"),
    END("3개의 숫자를 모두 맞히셨습니다! 게임종료"),
    NOTHING("낫싱");

    private String message;

    DefaultMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }
}
