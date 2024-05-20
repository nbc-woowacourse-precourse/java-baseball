package baseball.io;

import baseball.global.message.DefaultMessage;

public class Output {
    public void output(
            final int ball,
            final int strike
    ) {
        String format = "%d볼 %d스트라이크" + System.lineSeparator();
        // \n => 운영체재에 따라 적용이 안됨, System.lineSeparate() 권장
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
