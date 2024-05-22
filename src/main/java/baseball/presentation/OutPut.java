package baseball.presentation;

import static baseball.constant.Message.INPUT_MSG;
import static baseball.constant.Message.RESTART_MSG;
import static baseball.constant.Message.START_MSG;
import static baseball.constant.Message.SUCCESS_MSG;

public class OutPut {

    public void startMsg() {
        System.out.println(START_MSG.getMessage());
    }

    public void inputMsg() {
        System.out.print(INPUT_MSG.getMessage());
    }

    public void wonTheGame() {
        System.out.println(SUCCESS_MSG.getMessage());
        System.out.println(RESTART_MSG.getMessage());
    }
}
