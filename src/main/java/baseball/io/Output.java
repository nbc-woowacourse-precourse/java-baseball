package baseball.io;

public class Output {
    public void output(
            final int ball,
            final int strike
    ) {
        String format = "%d볼 %d스트라이크 \n";
        System.out.printf(format, ball, strike);
    }

    public void nothing() {
        System.out.println("낫싱");
    }

    public void endGame() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
