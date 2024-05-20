package baseball.io;

import baseball.constant.Message;
import camp.nextstep.edu.missionutils.Console;

public class Scanner {

    public String getPlayerNumbers() {
        System.out.print(Message.INPUT);

        return Console.readLine();
    }
}
