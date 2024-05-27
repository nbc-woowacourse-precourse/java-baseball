package baseball.presentation;

import static baseball.constant.Message.INPUT_MESSAGE;
import static baseball.constant.Message.RESTART_MESSAGE;
import static baseball.constant.Message.START_MESSAGE;
import static baseball.constant.Message.SUCCESS_MESSAGE;

public class OutPut {

    public void startMsg() {
        System.out.println(START_MESSAGE.getMessage());
    }

    public void inputMsg() {
        System.out.print(INPUT_MESSAGE.getMessage());
    }

    public void wonTheGame() {
        System.out.println(SUCCESS_MESSAGE.getMessage());
        System.out.println(RESTART_MESSAGE.getMessage());
    }
}
