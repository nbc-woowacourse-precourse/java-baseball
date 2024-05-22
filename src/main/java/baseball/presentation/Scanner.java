package baseball.presentation;

import static baseball.constant.Message.INPUT_MSG;

import camp.nextstep.edu.missionutils.Console;

public class Scanner {

    public String getPlayerNumbers() {
        System.out.print(INPUT_MSG.getMessage());

        return Console.readLine();
    }
}
