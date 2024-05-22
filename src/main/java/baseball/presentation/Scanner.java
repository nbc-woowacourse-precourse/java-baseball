package baseball.presentation;

import static baseball.constant.MenuChoice.RESTART;
import static baseball.constant.MenuChoice.TERMINATE;
import static baseball.constant.Message.ERROR_MSG;

import camp.nextstep.edu.missionutils.Console;

public class Scanner {

    public String getPlayerNumbers() {
        return Console.readLine();
    }

    public boolean restartOrTerminateGame() {
        String restart = getPlayerNumbers();

        if (restart.equals(TERMINATE.getMenuChoice())) {
            return true;
        }

        if (!restart.equals(RESTART.getMenuChoice())) {
            throw new IllegalArgumentException(ERROR_MSG.getMessage());
        }
        return false;
    }
}
