package baseball.io;

import baseball.global.message.DefaultMessage;

public class Output {
    public void strikeAndBall(
            final int ball,
            final int strike
    ) {
        String format = "%d볼 %d스트라이크" + System.lineSeparator();
        System.out.printf(format, ball, strike);
    }

    public void nothing() {
        System.out.println(DefaultMessage.NOTHING.getMessage());
    }

    public void endGame() {
        System.out.println(DefaultMessage.THREESTRIKE.getMessage());
        System.out.println(DefaultMessage.END.getMessage());
    }

    public void startGame() {
        System.out.println(DefaultMessage.START.getMessage());
    }

    public void restartGame() {
        System.out.println(DefaultMessage.RESTART.getMessage());
    }
}
