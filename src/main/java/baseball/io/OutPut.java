package baseball.io;

import baseball.constant.MenuChoice;
import baseball.constant.Message;
import camp.nextstep.edu.missionutils.Console;

public class OutPut {

    public void startMsg() {
        System.out.println(Message.START);
    }

    public void wonTheGame() {
        System.out.println(Message.SUCCESS);
        System.out.println(Message.RESTART);
    }

    public void restartGame() {
        String restart = Console.readLine();

        if (restart.equals(MenuChoice.RESTART.toString())) {
            System.out.println(Message.START);
        }
    }

    public void terminateGame() {
        String restart = Console.readLine();

        if (!restart.equals(MenuChoice.TERMINATE.toString())) {
            throw new IllegalArgumentException(Message.ERROR.getMessage());
        }
    }

}
