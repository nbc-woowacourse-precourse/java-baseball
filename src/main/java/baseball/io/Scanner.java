package baseball.io;

import static baseball.constant.Message.INPUT_MSG;

import camp.nextstep.edu.missionutils.Console;

public class Scanner {

    public String getPlayerNumbers() {
        System.out.print(INPUT_MSG);

        return Console.readLine();
    }
}
